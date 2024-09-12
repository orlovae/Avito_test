package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun ValueSpecification(
    value: String,
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.TypographyAvitoTest.textValueSpecificationProductDetail
    )
}

@Preview
@Composable
private fun ValueSpecificationPreview() {
    ValueSpecification(
        value = "Installation and demo for this product is done free of cost as part of this purchase. Our service partner will visit your location within 72 business hours from the delivery of the product"
    )
}
