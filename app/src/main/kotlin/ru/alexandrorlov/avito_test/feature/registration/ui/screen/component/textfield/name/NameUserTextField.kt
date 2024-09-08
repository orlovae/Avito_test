package ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.name

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
internal fun NameUserTextField(
    inputText: String,
    showErrorState: Boolean,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit,
) {
    var hasFocusName by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        BaseInputTextField(
            modifier = Modifier
                .onFocusEvent {
                    hasFocusName = it.isFocused
                },
            inputText = inputText,
            hasFocus = hasFocusName,
            errorState = showErrorState,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
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

        if (hasFocusName && showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.name_error_footer_text),
            )
        }
    }
}

@Composable
private fun NameUserTextField(
    inputText: String,
    showErrorState: Boolean,
    onValueChange: (String) -> Unit,
) {
    var hasFocusName by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        BaseInputTextField(
            modifier = Modifier
                .onFocusEvent {
                    hasFocusName = it.isFocused
                },
            inputText = inputText,
            hasFocus = hasFocusName,
            errorState = showErrorState,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
            ),
            decorationBox = @Composable { innerTextField ->
                DecorationBox(innerTextField)
            },
        )

        if (showErrorState) {
            SpacerSmallPadding()

            FooterTextField(
                title = stringResource(R.string.name_error_footer_text),
            )
        }
    }
}

@Preview
@Composable
private fun NameUserTextFieldStatePreview() {
    NameUserTextField(
        inputText = "Aleksandr Orlov",
        showErrorState = false,
        onValueChange = { },
    )
}

@Preview
@Composable
private fun NameUserTextFieldEmptyStatePreview() {
    NameUserTextField(
        inputText = "",
        showErrorState = true,
        onValueChange = { },
    )
}
