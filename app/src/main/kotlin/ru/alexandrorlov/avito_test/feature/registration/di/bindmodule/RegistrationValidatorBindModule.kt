package ru.alexandrorlov.avito_test.feature.registration.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.common.domain.validator.impl.EmailValidatorImpl
import ru.alexandrorlov.avito_test.common.domain.validator.impl.PasswordValidatorImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.NameValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.AllDataValidatorImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.NameValidatorImpl

@Module
interface RegistrationValidatorBindModule {

    @Binds
    fun bindNameValidatorImplToNameValidator(
        nameValidatorImpl: NameValidatorImpl
    ): NameValidator

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