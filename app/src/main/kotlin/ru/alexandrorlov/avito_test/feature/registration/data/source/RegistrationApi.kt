package ru.alexandrorlov.avito_test.feature.registration.data.source

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.alexandrorlov.avito_test.common.model.user.UserRegistration
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse

interface RegistrationApi {

    @POST("app/v1/users")
    suspend fun registrationUser(@Body user: UserRegistration): Response<RegistrationResponse>
}