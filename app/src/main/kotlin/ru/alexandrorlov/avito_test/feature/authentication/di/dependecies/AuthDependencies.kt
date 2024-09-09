package ru.alexandrorlov.avito_test.feature.authentication.di.dependecies

import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator

interface AuthDependencies {

    fun emailValidator(): EmailValidator

    fun passwordValidator(): PasswordValidator

//    fun registrationApi(): RegistrationApi

}