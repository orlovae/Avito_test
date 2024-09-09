package ru.alexandrorlov.avito_test.common.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserAuth(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String,
) : User
