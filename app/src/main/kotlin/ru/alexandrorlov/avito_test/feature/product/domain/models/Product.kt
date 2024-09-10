package ru.alexandrorlov.avito_test.feature.product.domain.models

import ru.alexandrorlov.avito_test.utils.StringValue

data class Product(
    val id: String,
    val urlPhoto: String,
    val title: StringValue,
    val price: String?,
    val discountedPrice: String?,
    val categoryList: List<String>,
)
