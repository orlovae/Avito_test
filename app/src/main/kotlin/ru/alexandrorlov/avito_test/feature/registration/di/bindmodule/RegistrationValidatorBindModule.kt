package ru.alexandrorlov.avito_test.feature.registration.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.EmailValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.PasswordValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.AllDataValidatorImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.EmailValidatorImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.PasswordValidatorImpl

@Module
interface RegistrationValidatorBindModule {

    @Binds
    fun bindPasswordValidatorImplToPasswordValidator(
        passwordValidatorImpl: PasswordValidatorImpl
    ): PasswordValidator

    @Binds
    fun bindEmailValidatorImplImplToEmailValidator(
        emailValidatorImpl: EmailValidatorImpl,
    ): EmailValidator

    @Binds
    fun bindAllDataValidatorImplImplToAllDataValidator(
        allDataValidatorImpl: AllDataValidatorImpl,
    ): AllDataValidator
}