package ru.alexandrorlov.avito_test.feature.product_detail.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailRemote(
    @SerialName("brand")
    val brand: String? = null,
    @SerialName("category")
    val category: List<String?> = emptyList(),
    @SerialName("description")
    val description: String? = null,
    @SerialName("discounted_price")
    val discountedPrice: Int? = null,
    @SerialName("_id")
    val id: String? = null,
    @SerialName("images")
    val urlPhotoList: List<String?> = emptyList(),
    @SerialName("name")
    val name: String? = null,
    @SerialName("price")
    val price: Int? = null,
    @SerialName("product_rating")
    val rating: Double? = null,
    @SerialName("product_specifications")
    val specifications: List<SpecificationRemote?> = emptyList(),
    @SerialName("__v")
    val v: Int? = null,
)