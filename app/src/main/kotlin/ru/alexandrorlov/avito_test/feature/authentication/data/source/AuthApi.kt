package ru.alexandrorlov.avito_test.feature.authentication.data.source

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.alexandrorlov.avito_test.common.model.user.UserAuth
import ru.alexandrorlov.avito_test.feature.authentication.data.models.AuthResponse

interface AuthApi {

    @POST("app/v1/users/auth/login")
    suspend fun authUser(@Body user: UserAuth): Response<AuthResponse>
}