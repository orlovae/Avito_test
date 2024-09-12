package ru.alexandrorlov.avito_test.feature.product_detail.ui.models


data class ProductDetailUI(
    val brand: String,
    val description: String,
    val discountedPrice: String,
    val id: String,
    val urlPhotoList: List<String>,
    val name: String,
    val price: String,
    val productSpecifications: List<ProductSpecificationUI>,
)
