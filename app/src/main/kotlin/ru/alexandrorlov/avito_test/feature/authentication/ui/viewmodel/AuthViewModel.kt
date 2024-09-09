package ru.alexandrorlov.avito_test.feature.authentication.ui.viewmodel

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
import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.model.state.Email
import ru.alexandrorlov.avito_test.common.model.state.Password
import ru.alexandrorlov.avito_test.common.model.user.UserAuth
import ru.alexandrorlov.avito_test.feature.authentication.domain.repository.AuthRepository
import ru.alexandrorlov.avito_test.feature.authentication.ui.models.AuthEvent
import ru.alexandrorlov.avito_test.feature.authentication.ui.models.AuthViewState
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator,
    private val allDataValidator: AllDataValidator,
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<AuthViewState> =
        MutableStateFlow(
            AuthViewState(
                email = Email.empty(),
                password = Password.empty(),
                isAllDataNotValid = true,
            )
        )
    val state: StateFlow<AuthViewState> = _state.asStateFlow()

    private val _event: MutableStateFlow<AuthEvent> = MutableStateFlow(
        AuthEvent.Init
    )
    val event: StateFlow<AuthEvent> = _event.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val inputEmail: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val inputPassword: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    val onClickButton: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        observeInputEmail()
        observeInputPassword()
        observeAllDataValid()
        observeOnClickButton()
    }

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
                val user: UserAuth = UserAuth(
                    email = _state.value.email.value,
                    password = _state.value.password.value,
                )
                when (val either: Either<String, Boolean> =
                    authRepository.authUser(user = user)) {

                    is Either.Success -> {
                        _event.emit(
                            AuthEvent.NavigateToProductListScreen
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
