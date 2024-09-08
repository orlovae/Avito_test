package ru.alexandrorlov.avito_test.common.ui.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
fun BaseInputTextField(
    modifier: Modifier = Modifier,
    inputText: String,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    regexPattern: Regex? = null,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    inputTextStyle: TextStyle = MaterialTheme.TypographyAvitoTest.textField,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit,
) {
    var textMemory by remember { mutableStateOf(inputText) }

    BasicTextField(
        value = textMemory,
        onValueChange = { text ->
            regexPattern?.let { regexPattern ->
                if (regexPattern.matches(text)) {
                    onValueChange(text)
                    textMemory = text
                }
            } ?: run {
                onValueChange(text)
                textMemory = text
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = inputTextStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
            decorationBox(innerTextField)
        },
    )
}

@Preview
@Composable
internal fun BaseInputTextFieldPreview() {
    BaseInputTextField(
        inputText = "BaseInputTextField",
        onValueChange = {},
        decorationBox = {},
    )
}
