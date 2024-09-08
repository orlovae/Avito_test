package ru.alexandrorlov.avito_test.feature.registration.ui.screen

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.common.ui.SpacerMediumPadding
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.registration.ui.models.RegistrationEvent
import ru.alexandrorlov.avito_test.feature.registration.ui.models.RegistrationViewState
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.AvitoTestButtonWithErrorState
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.email.EmailTextField
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.name.NameUserTextField
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.password.ConfirmPasswordInputTextField
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.password.PasswordInputTextFieldWithErrorState
import ru.alexandrorlov.avito_test.feature.registration.ui.viewmodel.RegistrationViewModel

@Composable
internal fun RegistrationScreen(
    navigateToAuthScreen: () -> Unit,
    viewModel: RegistrationViewModel = daggerViewModel(),
) {
    val focusManager: FocusManager = LocalFocusManager.current

    val state: RegistrationViewState = viewModel.state.collectAsState().value

    val event: RegistrationEvent = viewModel.event.collectAsState().value
    when (event) {
        RegistrationEvent.Init -> {}
        RegistrationEvent.NavigateToAuthScreen -> {
            navigateToAuthScreen()
        }
    }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {

                is SideEffect.SnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = sideEffect.message,
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                SnackbarAvitoTest(
                    snackBarText = data.visuals.message,
                )
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                NameUserTextField(
                    inputText = state.name.value,
                    showErrorState = state.name.isErrorState,
                    focusManager = focusManager,
                    onValueChange = { inputName ->
                        viewModel.inputName.tryEmit(inputName)
                    },
                )

                SpacerMediumPadding()

                EmailTextField(
                    inputText = state.email.value,
                    showErrorState = state.email.isErrorState,
                    focusManager = focusManager,
                    onValueChange = { inputEmail ->
                        viewModel.inputEmail.tryEmit(inputEmail)
                    },
                )

                SpacerMediumPadding()

                PasswordInputTextFieldWithErrorState(
                    password = state.password.value,
                    stayDigit = state.password.stayDigit,
                    showErrorState = state.password.isErrorState,
                    onPasswordChange = { inputPassword ->
                        viewModel.inputPassword.tryEmit(inputPassword)
                    },
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        },
                    ),
                )

                SpacerMediumPadding()

                ConfirmPasswordInputTextField(
                    password = state.confirmPassword.value,
                    showErrorState = state.confirmPassword.isErrorState,
                    onPasswordChange = { inputConfirmPassword ->
                        viewModel.inputConfirmPassword.tryEmit(inputConfirmPassword)
                    },
                    imeAction = ImeAction.Next,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Next)
                        },
                    ),
                )
            }

            AvitoTestButtonWithErrorState(
                modifier = Modifier
                    .focusable(),
                title = stringResource(id = R.string.button_title),
                onClick = {
                    viewModel.onClickButton.tryEmit("")
                },
                isErrorState = state.isAllDataNotValid,
            )
        }
    }
}

@Preview
@Composable
internal fun PreviewRegistrationScreen() {
    RegistrationScreen(
        navigateToAuthScreen = { },
    )
}