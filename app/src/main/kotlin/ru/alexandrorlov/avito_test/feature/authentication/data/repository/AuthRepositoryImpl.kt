package ru.alexandrorlov.avito_test.feature.authentication.data.repository

import retrofit2.Response
import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.user.UserAuth
import ru.alexandrorlov.avito_test.data.local.dao.TokenDao
import ru.alexandrorlov.avito_test.data.local.models.TokenDBO
import ru.alexandrorlov.avito_test.feature.authentication.data.models.AuthResponse
import ru.alexandrorlov.avito_test.feature.authentication.data.source.AuthRemoteSource
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.AuthScope
import ru.alexandrorlov.avito_test.feature.authentication.domain.repository.AuthRepository
import javax.inject.Inject

@AuthScope
class AuthRepositoryImpl @Inject constructor(
    private val remoteSource: AuthRemoteSource,
    private val localSource: TokenDao,
) : AuthRepository{

    override suspend fun authUser(user: UserAuth): Either<String, Boolean> {
        val response: Response<AuthResponse> = remoteSource.authUser(user)
        return if (response.isSuccessful) {

            val token: String? = response.body()?.token

            if (token != null) {

                val allLocalToken: List<TokenDBO> = localSource.getAllToken()

                val currentRemoteToken: TokenDBO = TokenDBO(token = token)

                if (allLocalToken.contains(currentRemoteToken).not()) {
                    localSource.clean()
                    localSource.insertToken(currentRemoteToken)
                }

                Either.success(true)
            } else {
                Either.fail(TOKEN_IS_NULL)
            }

        } else {
            Either.fail(response.errorBody()?.string() ?: "")
        }
    }

    companion object {
        private const val TOKEN_IS_NULL = "Token is null"
    }
}
