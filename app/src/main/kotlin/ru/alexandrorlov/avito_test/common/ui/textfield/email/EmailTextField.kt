package ru.alexandrorlov.avito_test.common.ui.textfield.email

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.common.ui.textfield.BaseInputTextField
import ru.alexandrorlov.avito_test.common.ui.textfield.FooterTextField

@Composable
internal fun EmailTextField(
    inputText: String,
    placeholderText: String,
    showErrorState: Boolean,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit,
) {
    var hasFocus by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        BaseInputTextField(
            modifier = Modifier
                .onFocusEvent {
                    hasFocus = it.isFocused
                },
            inputText = inputText,
            placeholderText = if (hasFocus) "" else placeholderText,
            hasFocus = hasFocus,
            errorState = showErrorState,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
            ),
            decorationBox = @Composable { innerTextField ->
                DecorationBox(innerTextField)
            },
        )

        if (hasFocus && showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.email_error_footer_text),
            )
        }
    }
}

@Composable
private fun EmailTextField(
    inputText: String,
    placeholderText: String,
    showErrorState: Boolean,
    onValueChange: (String) -> Unit,
) {
    val hasFocus by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        BaseInputTextField(
            inputText = inputText,
            placeholderText = if (hasFocus) "" else placeholderText,
            hasFocus = hasFocus,
            errorState = showErrorState,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            ),
            decorationBox = @Composable { innerTextField ->
                DecorationBox(innerTextField)
            },
        )

        if (showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.email_error_footer_text),
            )
        }
    }
}

@Preview
@Composable
private fun EmailTextFieldStatePreview() {
    EmailTextField(
        inputText = "email@email.ru",
        placeholderText = stringResource(id = R.string.email_text_placeholder),
        showErrorState = false,
        onValueChange = { },
    )
}

@Preview
@Composable
private fun EmailTextFieldEmptyStatePreview() {
    EmailTextField(
        inputText = "",
        placeholderText = stringResource(id = R.string.email_text_placeholder),
        showErrorState = true,
        onValueChange = { },
    )
}
