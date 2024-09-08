package ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.password

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
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.common.ui.textfield.BaseInputTextFieldWithErrorState
import ru.alexandrorlov.avito_test.common.ui.textfield.FooterTextField

@Composable
internal fun ConfirmPasswordInputTextField(
    password: String,
    showErrorState: Boolean,
    onPasswordChange: (String) -> Unit,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions,
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    val visualTransformation by remember(passwordHidden) {
        mutableStateOf(
            if (passwordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
    }

    var hasFocus by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        BaseInputTextFieldWithErrorState(
            modifier = Modifier
                .onFocusEvent {
                    hasFocus = it.isFocused
                },
            inputText = password,
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
