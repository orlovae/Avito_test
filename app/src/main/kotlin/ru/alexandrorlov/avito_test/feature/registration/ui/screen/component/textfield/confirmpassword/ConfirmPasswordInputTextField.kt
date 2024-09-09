package ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.confirmpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.common.ui.textfield.BaseInputTextField
import ru.alexandrorlov.avito_test.common.ui.textfield.FooterTextField
import ru.alexandrorlov.avito_test.common.ui.textfield.password.DecorationBox

@Composable
internal fun ConfirmPasswordInputTextField(
    password: String,
    placeholderText: String,
    showErrorState: Boolean,
    onPasswordChange: (String) -> Unit,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions,
) {
    var hasFocus by rememberSaveable { mutableStateOf(false) }

    var passwordHidden by rememberSaveable { mutableStateOf(false) }

    val visualTransformation by remember(passwordHidden) {
        mutableStateOf(
            if (passwordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
    }

    Column {
        BaseInputTextField(
            modifier = Modifier
                .onFocusEvent {
                    hasFocus = it.isFocused
                },
            inputText = password,
            placeholderText = if (hasFocus) "" else placeholderText,
            hasFocus = hasFocus,
            errorState = showErrorState,
            onValueChange = { onPasswordChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = imeAction,
            ),
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            decorationBox = @Composable { innerTextField ->
                DecorationBox(
                    innerTextField = innerTextField,
                    onPasswordHiddenChange = {
                        passwordHidden = it
                    },
                )
            },
        )

        if (hasFocus && showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.confirm_password_error_state_text),
            )
        }
    }
}

@Composable
private fun ConfirmPasswordInputTextField(
    password: String,
    placeholderText: String,
    showErrorState: Boolean,
    onPasswordChange: (String) -> Unit,
) {
    var hasFocus by rememberSaveable { mutableStateOf(false) }

    var passwordHidden by rememberSaveable { mutableStateOf(false) }

    val visualTransformation by remember(passwordHidden) {
        mutableStateOf(
            if (passwordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
    }

    Column {
        BaseInputTextField(
            modifier = Modifier
                .onFocusEvent {
                    hasFocus = it.isFocused
                },
            inputText = password,
            placeholderText = if (hasFocus) "" else placeholderText,
            hasFocus = hasFocus,
            errorState = showErrorState,
            onValueChange = { onPasswordChange(it) },
            visualTransformation = visualTransformation,
            decorationBox = @Composable { innerTextField ->
                DecorationBox(
                    innerTextField = innerTextField,
                    onPasswordHiddenChange = {
                        passwordHidden = it
                    },
                )
            },
        )

        if (showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.confirm_password_error_state_text),
            )
        }
    }
}

@Preview
@Composable
private fun ConfirmPasswordInputTextFieldStatePreview() {
    ConfirmPasswordInputTextField(
        password = "12345678",
        placeholderText = stringResource(id = R.string.confirm_password_text_placeholder),
        showErrorState = false,
        onPasswordChange = { },
    )
}

@Preview
@Composable
private fun ConfirmPasswordInputTextFieldEmptyStatePreview() {
    ConfirmPasswordInputTextField(
        password = "",
        placeholderText = stringResource(id = R.string.confirm_password_text_placeholder),
        showErrorState = true,
        onPasswordChange = { },
    )
}