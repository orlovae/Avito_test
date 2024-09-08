package ru.alexandrorlov.avito_test.feature.registration.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.registration.data.repository.RegistrationRepositoryImpl
import ru.alexandrorlov.avito_test.feature.registration.domain.repository.RegistrationRepository

@Module
interface RegistrationRepositoryBindModule {

    @Binds
    fun bindRegistrationRepositoryImplToRegistrationRepository(
        registrationRepositoryImpl: RegistrationRepositoryImpl
    ): RegistrationRepository

}