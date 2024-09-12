package ru.alexandrorlov.avito_test.common.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest
import ru.alexandrorlov.avito_test.utils.groupingUsedToString

@Composable
fun PriceBlock(
    discountedPrice: String,
    price: String,
) {
    Column {
        if (discountedPrice.isNotBlank()) {
            Text(
                text = discountedPrice,
                style = MaterialTheme.TypographyAvitoTest.textDiscountedPriceProduct,
            )

            if (price.isNotBlank()) {
                Text(
                    text = price,
                    style = MaterialTheme.TypographyAvitoTest.textPriceProduct,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PriceBlockPreview() {
    PriceBlock(
        discountedPrice = "${9999.groupingUsedToString()} \u20BD",
        price = "${20000.groupingUsedToString()} \u20BD",
    )
}

@Preview
@Composable
private fun PriceBlockDiscountedPriceBlankPreview() {
    PriceBlock(
        discountedPrice = "",
        price = "${20000.groupingUsedToString()} \u20BD",
    )
}

@Preview
@Composable
private fun PriceBlockPriceBlankPreview() {
    PriceBlock(
        discountedPrice = "${9999.groupingUsedToString()} \u20BD",
        price = "",
    )
}
