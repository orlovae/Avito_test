package ru.alexandrorlov.avito_test.feature.authentication.data.repository

import retrofit2.Response
import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.user.UserAuth
import ru.alexandrorlov.avito_test.feature.authentication.data.models.AuthResponse
import ru.alexandrorlov.avito_test.feature.authentication.data.source.AuthRemoteSource
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.AuthScope
import ru.alexandrorlov.avito_test.feature.authentication.domain.repository.AuthRepository
import javax.inject.Inject

@AuthScope
class AuthRepositoryImpl @Inject constructor(
    private val remoteSource: AuthRemoteSource,
) : AuthRepository{

    override suspend fun authUser(user: UserAuth): Either<String, AuthResponse> {
        val response: Response<AuthResponse> = remoteSource.authUser(user)
        return if (response.isSuccessful) {
            Either.success(response.body() ?: AuthResponse())
        } else {
            Either.fail(response.errorBody()?.string() ?: "")
        }
    }
}
