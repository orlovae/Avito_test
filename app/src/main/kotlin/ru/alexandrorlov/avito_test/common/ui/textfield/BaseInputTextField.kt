package ru.alexandrorlov.avito_test.common.ui.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.BackgroundTextField
import ru.alexandrorlov.avito_test.ui.theme.PlaceholderTextField
import ru.alexandrorlov.avito_test.ui.theme.RedBorder
import ru.alexandrorlov.avito_test.ui.theme.ShapesAvitoTest
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun BaseInputTextField(
    modifier: Modifier = Modifier,
    inputText: String,
    placeholderText: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    hasFocus: Boolean,
    errorState: Boolean,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    inputTextStyle: TextStyle = MaterialTheme.TypographyAvitoTest.textField,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit,
) {
    BasicTextField(
        value = inputText.ifBlank { placeholderText },
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding),
            )
            .background(
                color = BackgroundTextField,
                shape = MaterialTheme.ShapesAvitoTest.shapeTextField,
            )
            .border(
                width = dimensionResource(R.dimen.border_thickness_text_field),
                color = if (hasFocus && errorState) RedBorder else Color.Unspecified,
                shape = MaterialTheme.ShapesAvitoTest.shapeTextField,
            ),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = if (inputText.isBlank()) inputTextStyle.copy(color = PlaceholderTextField)
        else inputTextStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
            decorationBox(innerTextField)
        },
    )
}

@Preview()
@Composable
private fun BaseInputTextFieldEmptyPreview() {
    BaseInputTextField(
        inputText = "",
        placeholderText = "Телефон или почта",
        hasFocus = false,
        errorState = false,
        onValueChange = {},
        decorationBox = @Composable { innerTextField ->
            DecorationBox(
                innerTextField
            )
        },
    )
}

@Preview()
@Composable
private fun BaseInputTextFieldPreview() {
    BaseInputTextField(
        inputText = "Base Input Text Field",
        hasFocus = false,
        errorState = false,
        onValueChange = {},
        decorationBox = @Composable { innerTextField ->
            DecorationBox(
                innerTextField
            )
        },
    )
}

@Preview()
@Composable
private fun BaseInputTextFieldEmptyErrorStatePreview() {
    BaseInputTextField(
        inputText = "",
        placeholderText = "Телефон или почта",
        hasFocus = true,
        errorState = true,
        onValueChange = {},
        decorationBox = @Composable { innerTextField ->
            DecorationBox(
                innerTextField
            )
        },
    )
}

@Preview()
@Composable
private fun BaseInputTextFieldErrorStatePreview() {
    BaseInputTextField(
        inputText = "Base Input Text Field",
        hasFocus = true,
        errorState = true,
        onValueChange = {},
        decorationBox = @Composable { innerTextField ->
            DecorationBox(
                innerTextField
            )
        },
    )
}