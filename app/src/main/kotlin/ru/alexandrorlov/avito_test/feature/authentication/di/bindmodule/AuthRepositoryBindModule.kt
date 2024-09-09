package ru.alexandrorlov.avito_test.feature.authentication.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.authentication.data.repository.AuthRepositoryImpl
import ru.alexandrorlov.avito_test.feature.authentication.domain.repository.AuthRepository

@Module
interface AuthRepositoryBindModule {

    @Binds
    fun bindAuthRepositoryImplToAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

}