package ru.alexandrorlov.avito_test.feature.registration.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResponse(
    @SerialName("data")
    val data: Data? = null,
    @SerialName("status")
    val status: String? = null
)