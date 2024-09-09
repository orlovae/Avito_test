package ru.alexandrorlov.avito_test.feature.authentication.domain.repository

import ru.alexandrorlov.avito_test.common.data.Either
import ru.alexandrorlov.avito_test.common.model.user.UserAuth

interface AuthRepository {

    suspend fun authUser(user: UserAuth): Either<String, Boolean>
}
