package ru.alexandrorlov.avito_test.feature.registration.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.EmailValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.ConfirmPassword
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.Email
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.Name
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.Password
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.RegistrationViewState
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val passwordValidator: PasswordValidator,
    private val emailValidator: EmailValidator,
    private val allDataValidator: AllDataValidator,
) : ViewModel() {
    private val _state: MutableStateFlow<RegistrationViewState> =
        MutableStateFlow(
            RegistrationViewState(
                name = Name.empty(),
                email = Email.empty(),
                password = Password.empty(),
                confirmPassword = ConfirmPassword.empty(),
                isAllDataNotValid = true,
            )
        )
    val state: StateFlow<RegistrationViewState> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val inputName: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputEmail: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputPassword: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputConfirmPassword: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    val onClickButton: MutableStateFlow<Boolean> = MutableStateFlow(false)

    init {
        observeInputName()
        observeInputEmail()
        observeInputPassword()
        observeInputConfirmPassword()
        observeAllDataValid()
    }

    private fun observeInputName() =
        inputName
            .onEach { name ->
                _state.update {
                    _state.value.copy(
                        name = Name(
                            value = name,
                            isErrorState = name.isBlank(),
                        )
                    )
                }
            }
            .launchIn(viewModelScope)

    private fun observeInputEmail() =
        inputEmail
            .onEach { email ->
                val isErrorState = emailValidator.validateEmail(inputValue = email)

                _state.update {
                    _state.value.copy(
                        email = Email(
                            value = email,
                            isErrorState = isErrorState,
                        )
                    )
                }
            }
            .launchIn(viewModelScope)

    private fun observeInputPassword() =
        inputPassword
            .onEach { password ->
                _state.update {
                    _state.value.copy(
                        password = passwordValidator.validatePassword(inputValue = password)
                    )
                }
            }
            .launchIn(viewModelScope)

    private fun observeInputConfirmPassword() =
        inputConfirmPassword
            .onEach { confirmPassword ->
                val isErrorState = passwordValidator.getShowErrorStateConfirmPassword(
                    inputValue = confirmPassword,
                    password = state.value.password.value,
                )

                _state.update {
                    _state.value.copy(
                        confirmPassword = ConfirmPassword(
                            value = confirmPassword,
                            isErrorState = isErrorState,
                        )
                    )
                }
            }
            .launchIn(viewModelScope)

    private fun observeAllDataValid() =
        _state
            .onEach { state ->
                val isAllDataNotValid: Boolean = allDataValidator.valid(state = state)

                _state.update {
                    _state.value.copy(
                        isAllDataNotValid = isAllDataNotValid
                    )
                }
            }
            .launchIn(viewModelScope)
}
