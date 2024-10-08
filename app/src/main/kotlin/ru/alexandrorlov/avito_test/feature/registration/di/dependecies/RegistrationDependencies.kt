package ru.alexandrorlov.avito_test.feature.registration.di.dependecies

import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.registration.data.source.RegistrationApi

interface RegistrationDependencies {

    fun emailValidator(): EmailValidator

    fun passwordValidator(): PasswordValidator

    fun registrationApi(): RegistrationApi

}