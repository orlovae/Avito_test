package ru.alexandrorlov.avito_test.feature.product.ui.models

sealed class ProductListEvent {
    data object Init : ProductListEvent()
    data class NavigateToProductDetailScreen(val id: String) : ProductListEvent()
}