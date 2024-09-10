package ru.alexandrorlov.avito_test.feature.product.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductSpecification(
    @SerialName("key")
    val key: String? = null,
    @SerialName("value")
    val value: String? = null
)