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
import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.model.User
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse
import ru.alexandrorlov.avito_test.feature.registration.domain.repository.RegistrationRepository
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.EmailValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.NameValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.models.ConfirmPassword
import ru.alexandrorlov.avito_test.feature.registration.ui.models.Email
import ru.alexandrorlov.avito_test.feature.registration.ui.models.Name
import ru.alexandrorlov.avito_test.feature.registration.ui.models.Password
import ru.alexandrorlov.avito_test.feature.registration.ui.models.RegistrationEvent
import ru.alexandrorlov.avito_test.feature.registration.ui.models.RegistrationViewState
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val nameValidator: NameValidator,
    private val passwordValidator: PasswordValidator,
    private val emailValidator: EmailValidator,
    private val allDataValidator: AllDataValidator,
    private val registrationRepository: RegistrationRepository,
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

    private val _event: MutableStateFlow<RegistrationEvent> = MutableStateFlow(
        RegistrationEvent.Init
    )
    val event: StateFlow<RegistrationEvent> = _event.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val inputName: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputEmail: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputPassword: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputConfirmPassword: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    val onClickButton: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        observeInputName()
        observeInputEmail()
        observeInputPassword()
        observeInputConfirmPassword()
        observeAllDataValid()
        observeOnClickButton()
    }

    private fun observeInputName() =
        inputName
            .onEach { name ->
                val isErrorState = nameValidator.getShowErrorState(inputValue = name)

                _state.update {
                    _state.value.copy(
                        name = Name(
                            value = name,
                            isErrorState = isErrorState,
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

    private fun observeOnClickButton() {
        onClickButton
            .onEach {
                val user: User = User(
                    name = _state.value.name.value,
                    email = _state.value.email.value,
                    password = _state.value.password.value,
                    cpassword = _state.value.confirmPassword.value,
                )
                when (val either: Either<String, RegistrationResponse> =
                    registrationRepository.registrationUser(user = user)) {

                    is Either.Success -> {
                        _event.emit(
                            RegistrationEvent.NavigateToAuthScreen
                        )
                    }

                    is Either.Fail -> {
                        _sideEffect.emit(
                            SideEffect.SnackBar(
                                message = either.value.getErrorMessage()
                            )
                        )
                    }
                }

            }
            .launchIn(viewModelScope)
    }

}
