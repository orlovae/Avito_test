package ru.alexandrorlov.avito_test.feature.registration.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("city")
    val city: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("postalCode")
    val postalCode: String? = null,
    @SerialName("state")
    val state: String? = null,
    @SerialName("street")
    val street: String? = null
)