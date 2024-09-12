package ru.alexandrorlov.avito_test.feature.product_detail.domain.models


data class ProductDetail(
    val brand: String,
    val description: String,
    val discountedPrice: String,
    val id: String,
    val urlPhotoList: List<String>,
    val name: String,
    val price: String,
    val productSpecifications: List<ProductSpecification>,
) {

    companion object {
        fun empty(): ProductDetail =
            ProductDetail(
                brand = "",
                description = "",
                discountedPrice = "",
                id = "",
                urlPhotoList = emptyList(),
                name = "",
                price = "",
                productSpecifications = emptyList()
            )
    }
}