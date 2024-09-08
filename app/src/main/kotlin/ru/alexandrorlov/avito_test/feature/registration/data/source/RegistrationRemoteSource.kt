package ru.alexandrorlov.avito_test.feature.registration.data.source

import retrofit2.Response
import ru.alexandrorlov.avito_test.common.model.User
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse
import ru.alexandrorlov.avito_test.feature.registration.di.RegistrationScope
import javax.inject.Inject

@RegistrationScope
class RegistrationRemoteSource @Inject constructor(private val registrationApi: RegistrationApi) {

    suspend fun registrationUser(user: User): Response<RegistrationResponse> =
        registrationApi.registrationUser(user)
}