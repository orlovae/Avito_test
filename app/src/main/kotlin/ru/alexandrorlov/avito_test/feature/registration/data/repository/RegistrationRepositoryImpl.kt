package ru.alexandrorlov.avito_test.feature.registration.data.repository

import retrofit2.Response
import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.user.UserRegistration
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse
import ru.alexandrorlov.avito_test.feature.registration.data.source.RegistrationRemoteSource
import ru.alexandrorlov.avito_test.feature.registration.di.annotation.RegistrationScope
import ru.alexandrorlov.avito_test.feature.registration.domain.repository.RegistrationRepository
import javax.inject.Inject

@RegistrationScope
class RegistrationRepositoryImpl @Inject constructor(
    private val remoteSource: RegistrationRemoteSource,
) : RegistrationRepository{

    override suspend fun registrationUser(user: UserRegistration): Either<String, RegistrationResponse> {
        val response: Response<RegistrationResponse> = remoteSource.registrationUser(user)
        return if (response.isSuccessful) {
            Either.success(response.body() ?: RegistrationResponse())
        } else {
            Either.fail(response.errorBody()?.string() ?: "")
        }
    }
}
