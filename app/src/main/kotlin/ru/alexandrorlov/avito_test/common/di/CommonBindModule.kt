package ru.alexandrorlov.avito_test.common.di

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.common.domain.validator.impl.EmailValidatorImpl
import ru.alexandrorlov.avito_test.common.domain.validator.impl.PasswordValidatorImpl

@Module
interface CommonBindModule {

    @Binds
    fun bindEmailValidatorImplImplToEmailValidator(
        emailValidatorImpl: EmailValidatorImpl,
    ): EmailValidator

    @Binds
    fun bindPasswordValidatorImplToPasswordValidator(
        passwordValidatorImpl: PasswordValidatorImpl
    ): PasswordValidator
}