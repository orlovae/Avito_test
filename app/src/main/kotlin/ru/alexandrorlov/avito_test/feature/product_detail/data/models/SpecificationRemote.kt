package ru.alexandrorlov.avito_test.feature.product_detail.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecificationRemote(
    @SerialName("key")
    val key: String? = null,
    @SerialName("value")
    val value: String? = null,
)