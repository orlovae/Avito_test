package ru.alexandrorlov.avito_test.feature.registration.domain.repository

import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.user.UserRegistration
import ru.alexandrorlov.avito_test.feature.registration.data.models.RegistrationResponse

interface RegistrationRepository {

    suspend fun registrationUser(user: UserRegistration): Either<String, RegistrationResponse>
}
