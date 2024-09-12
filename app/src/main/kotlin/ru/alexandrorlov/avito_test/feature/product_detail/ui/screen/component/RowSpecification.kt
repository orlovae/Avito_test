package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.SpecificationUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.data.getFakeSpecificationForPreview

@Composable
internal fun RowSpecification(
    specification: SpecificationUI,
) {
    if (specification.key.isNotBlank()) {
        Row {
            val text: AnnotatedString = annotatedString(specification)

            Text(text = text)
        }
    } else {
        ValueSpecification(value = specification.value)
    }
}

@Preview
@Composable
private fun RowSpecificationPreview() {
    RowSpecification(
        specification = getFakeSpecificationForPreview().first(),
    )
}

@Preview
@Composable
private fun RowEmptyKeySpecificationPreview() {
    RowSpecification(
        specification = getFakeSpecificationForPreview()[1],
    )
}
