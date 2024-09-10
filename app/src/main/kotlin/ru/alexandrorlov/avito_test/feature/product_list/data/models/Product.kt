package ru.alexandrorlov.avito_test.feature.product_list.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("Data")
    val data: List<Data?> = emptyList(),
    @SerialName("status")
    val status: String? = null
)