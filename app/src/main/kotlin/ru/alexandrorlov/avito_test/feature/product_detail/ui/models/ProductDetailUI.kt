package ru.alexandrorlov.avito_test.feature.product_detail.ui.models

import ru.alexandrorlov.avito_test.utils.StringValue


data class ProductDetailUI(
    val brand: String,
    val description: String,
    val discountedPrice: StringValue,
    val id: String,
    val urlPhotoList: List<String>,
    val name: String,
    val price: StringValue,
    val specifications: List<SpecificationUI>,
)
