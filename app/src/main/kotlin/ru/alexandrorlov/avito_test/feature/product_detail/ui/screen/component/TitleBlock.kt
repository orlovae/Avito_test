package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.data.getFakeProductDetailUI
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun TitleBlock(
    product: ProductDetailUI,
) {
    Column {
        Text(
            text = product.name,
            style = MaterialTheme.TypographyAvitoTest.textNameProductDetail
        )

        if (product.description.isNotBlank()) {
            Text(
                text = product.description,
                style = MaterialTheme.TypographyAvitoTest.textNameProductDetail
            )
        }
    }
}

@Preview
@Composable
internal fun TitleBlockPreview() {
    TitleBlock(
        product = getFakeProductDetailUI(),
    )
}
