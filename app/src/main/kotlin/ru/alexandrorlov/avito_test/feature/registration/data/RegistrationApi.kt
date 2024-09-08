package ru.alexandrorlov.avito_test.feature.registration.data

import retrofit2.http.POST
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse

interface RegistrationApi {

    @POST("/app/v1/users")
    suspend fun registrationUser(): RegistrationResponse
}