package ru.alexandrorlov.avito_test.feature.product.ui.models

import androidx.annotation.StringRes
import ru.alexandrorlov.avito_test.R

sealed class Filter(
    @StringRes
    val titleId: Int,
) {
    data object PriceUp : Filter(titleId = R.string.price_up_filter)
    data object PriceDown : Filter(titleId = R.string.price_down_filter)
}