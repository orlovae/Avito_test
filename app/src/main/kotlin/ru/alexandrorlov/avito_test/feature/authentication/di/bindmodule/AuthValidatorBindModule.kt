package ru.alexandrorlov.avito_test.feature.authentication.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.Auth
import ru.alexandrorlov.avito_test.feature.authentication.domain.validators.impl.AllDataValidatorAuthImpl

@Module
interface AuthValidatorBindModule {

    @[Binds Auth]
    fun bindAllDataValidatorImplImplToAllDataValidator(
        allDataValidatorImpl: AllDataValidatorAuthImpl,
    ): AllDataValidator
}