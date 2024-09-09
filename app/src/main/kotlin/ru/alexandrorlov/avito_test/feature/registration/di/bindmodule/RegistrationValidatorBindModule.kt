package ru.alexandrorlov.avito_test.feature.registration.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.di.Registration
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.NameValidator
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.AllDataValidatorRegistrationImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.NameValidatorImpl

@Module
interface RegistrationValidatorBindModule {

    @Binds
    fun bindNameValidatorImplToNameValidator(
        nameValidatorImpl: NameValidatorImpl
    ): NameValidator

    @[Binds Registration]
    fun bindAllDataValidatorImplImplToAllDataValidator(
        allDataValidatorImpl: AllDataValidatorRegistrationImpl,
    ): AllDataValidator
}