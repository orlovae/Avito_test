package ru.alexandrorlov.avito_test.feature.authentication.data.source

import retrofit2.Response
import ru.alexandrorlov.avito_test.common.model.user.UserAuth
import ru.alexandrorlov.avito_test.feature.authentication.data.models.AuthResponse
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.AuthScope
import javax.inject.Inject

@AuthScope
class AuthRemoteSource @Inject constructor(private val authApi: AuthApi) {

    suspend fun authUser(user: UserAuth): Response<AuthResponse> =
        authApi.authUser(user)
}