package ru.alexandrorlov.avito_test.feature.registration.domain.repository

import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.User
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse

interface RegistrationRepository {

    suspend fun registrationUser(user: User): Either<String, RegistrationResponse>
}
