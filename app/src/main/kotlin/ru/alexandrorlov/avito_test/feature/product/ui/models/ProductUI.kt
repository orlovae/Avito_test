package ru.alexandrorlov.avito_test.feature.product.ui.models

import ru.alexandrorlov.avito_test.utils.StringValue

data class ProductUI(
    val id: String,
    val urlPhoto: String,
    val title: StringValue,
    val price: StringValue,
    val discountedPrice: StringValue,
    val categoryList: List<String>,
)
