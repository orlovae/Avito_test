package ru.alexandrorlov.avito_test.feature.product.data.models

import androidx.annotation.StringRes

data class Filter(
    @StringRes
    val idTitle: Int,
    val query: String,
    val isSelected: Boolean = false
) {

    companion object {
        internal const val QUERY_PRICE_UP = "+price"
        internal const val QUERY_PRICE_DOWN = "-price"
    }
}