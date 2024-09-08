package ru.alexandrorlov.avito_test.common.ui.textfield

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
fun FooterTextField(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier
            .padding(
                start = dimensionResource(R.dimen.medium_padding),
            ),
        text = title,
        style = MaterialTheme.TypographyAvitoTest.footerTextInTextFiled,
    )
}

@Preview
@Composable
private fun FooterTextFieldPreview() {
    FooterTextField(
        title = "footer"
    )
}
