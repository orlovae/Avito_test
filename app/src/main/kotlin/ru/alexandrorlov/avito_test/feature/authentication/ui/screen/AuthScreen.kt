package ru.alexandrorlov.avito_test.feature.authentication.ui.screen

import android.content.Context
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.AvitoTestButton
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.common.ui.SpacerMediumPadding
import ru.alexandrorlov.avito_test.common.ui.TopBarAvitoTest
import ru.alexandrorlov.avito_test.common.ui.textfield.email.EmailTextField
import ru.alexandrorlov.avito_test.common.ui.textfield.password.PasswordInputTextField
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.authentication.ui.models.AuthEvent
import ru.alexandrorlov.avito_test.feature.authentication.ui.models.AuthViewState
import ru.alexandrorlov.avito_test.feature.authentication.ui.viewmodel.AuthViewModel

@Composable
fun AuthScreen(
    navigateToScreen: () -> Unit,
) {
    AuthScreen(
        viewModel = daggerViewModel(),
        navigateToScreen = navigateToScreen,
        )
}

@Composable
private fun AuthScreen(
    viewModel: AuthViewModel,
    navigateToScreen: () -> Unit,
) {
    val focusManager: FocusManager = LocalFocusManager.current

    val state: AuthViewState = viewModel.state.collectAsState().value

    val event: AuthEvent = viewModel.event.collectAsState().value
    when (event) {
        AuthEvent.Init -> {}
        AuthEvent.NavigateToProductListScreen -> {
            navigateToScreen()
        }
    }

    val snackbarHostState = remember { SnackbarHostState() }

    val context: Context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {

                is SideEffect.SnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = sideEffect.message.asString(context = context),
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopBarAvitoTest(title = stringResource(id = R.string.top_bar_auth_title))
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                SnackbarAvitoTest(
                    snackBarText = data.visuals.message,
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                SpacerMediumPadding()

                EmailTextField(
                    inputText = state.email.value,
                    placeholderText = stringResource(id = R.string.email_text_placeholder),
                    showErrorState = state.email.isErrorState,
                    focusManager = focusManager,
                    onValueChange = { inputEmail ->
                        viewModel.inputEmail.tryEmit(inputEmail)
                    },
                )

                SpacerMediumPadding()

                PasswordInputTextField(
                    password = state.password.value,
                    placeholderText = stringResource(id = R.string.password_text_placeholder),
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
            }

            AvitoTestButton(
                modifier = Modifier
                    .focusable(),
                title = stringResource(id = R.string.button_auth_title),
                onClick = {
                    viewModel.onClickButton.tryEmit("")
                },
                isErrorState = state.isAllDataNotValid,
            )
        }
    }
}