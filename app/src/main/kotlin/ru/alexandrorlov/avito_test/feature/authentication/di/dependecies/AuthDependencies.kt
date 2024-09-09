package ru.alexandrorlov.avito_test.feature.authentication.di.dependecies

import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.authentication.data.source.AuthApi

interface AuthDependencies {

    fun emailValidator(): EmailValidator

    fun passwordValidator(): PasswordValidator

    fun authApi(): AuthApi

}