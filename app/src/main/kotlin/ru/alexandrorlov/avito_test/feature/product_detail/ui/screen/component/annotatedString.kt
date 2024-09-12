package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.SpecificationUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.data.getFakeSpecificationForPreview
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun annotatedString(specification: SpecificationUI): AnnotatedString {
    val colonSing: String = stringResource(id = R.string.colon_sing)

    val text: AnnotatedString = buildAnnotatedString {
        withStyle(
            style = MaterialTheme.TypographyAvitoTest.textKeySpecificationProductDetailSpanStyle,
        ) {
            append(specification.key)
            append("$colonSing ")
        }
        withStyle(
            style = MaterialTheme.TypographyAvitoTest.textValueSpecificationProductDetailSpanStyle,
        ) {
            append(specification.value)
        }
    }
    return text
}

@Preview
@Composable
private fun AnnotatedStringPreview() {
    annotatedString(specification = getFakeSpecificationForPreview().first())
}