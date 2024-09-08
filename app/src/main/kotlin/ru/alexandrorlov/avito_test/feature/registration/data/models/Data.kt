package ru.alexandrorlov.avito_test.feature.registration.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("address")
    val address: Address? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("photo")
    val photo: String? = null
)