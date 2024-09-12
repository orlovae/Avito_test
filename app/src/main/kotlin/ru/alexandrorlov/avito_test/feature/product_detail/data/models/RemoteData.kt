package ru.alexandrorlov.avito_test.feature.product_detail.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteData(
    @SerialName("data")
    val product: ProductDetailRemote? = null,
    @SerialName("status")
    val status: String? = null,
)