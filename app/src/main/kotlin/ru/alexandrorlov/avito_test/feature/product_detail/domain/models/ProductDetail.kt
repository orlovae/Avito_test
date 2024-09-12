package ru.alexandrorlov.avito_test.feature.product_detail.domain.models

import ru.alexandrorlov.avito_test.utils.StringValue


data class ProductDetail(
    val brand: String,
    val description: String,
    val discountedPrice: StringValue,
    val id: String,
    val urlPhotoList: List<String>,
    val name: String,
    val price: StringValue,
    val specifications: List<Specification>,
) {

    companion object {
        fun empty(): ProductDetail =
            ProductDetail(
                brand = "",
                description = "",
                discountedPrice = StringValue.DynamicString(""),
                id = "",
                urlPhotoList = emptyList(),
                name = "",
                price = StringValue.DynamicString(""),
                specifications = emptyList()
            )
    }
}