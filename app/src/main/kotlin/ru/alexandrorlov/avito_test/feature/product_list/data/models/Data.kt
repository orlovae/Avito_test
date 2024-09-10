package ru.alexandrorlov.avito_test.feature.product_list.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("brand")
    val brand: String? = null,
    @SerialName("category")
    val category: List<String?> = emptyList(),
    @SerialName("description")
    val description: String? = null,
    @SerialName("discounted_price")
    val discountedPrice: Int? = null,
    @SerialName("edit")
    val edit: String? = null,
    @SerialName("_id")
    val id: String? = null,
    @SerialName("images")
    val images: List<String?> = emptyList(),
    @SerialName("name")
    val name: String? = null,
    @SerialName("price")
    val price: Int? = null,
    @SerialName("product_rating")
    val productRating: Double? = null,
    @SerialName("product_specifications")
    val productSpecifications: List<ProductSpecification?> = emptyList()
)