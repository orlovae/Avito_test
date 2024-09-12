package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.AvitoTestButton
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.data.getFakeProductDetailUI

@Composable
internal fun ContentScreen(
    product: ProductDetailUI,
    onClickButtonBuy: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        ImageListRowAndTextSpecificationsBlock(product = product)

        AvitoTestButton(
            title = stringResource(id = R.string.button_product_detail_title),
            isErrorState = false,
            onClick = { onClickButtonBuy() },
        )
    }
}

@Preview
@Composable
private fun ContentScreenPreview() {
    ContentScreen(
        product = getFakeProductDetailUI(),
        onClickButtonBuy = {  },
    )
}