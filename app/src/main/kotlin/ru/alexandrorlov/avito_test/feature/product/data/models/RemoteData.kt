package ru.alexandrorlov.avito_test.feature.product.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteData(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("Data")
    val productList: List<ProductRemote?> = emptyList(),
    @SerialName("status")
    val status: String? = null
)