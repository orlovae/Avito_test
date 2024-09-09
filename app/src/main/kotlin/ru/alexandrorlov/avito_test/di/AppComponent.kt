package ru.alexandrorlov.avito_test.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.alexandrorlov.avito_test.common.di.CommonModule
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.data.local.dao.TokenDao
import ru.alexandrorlov.avito_test.data.local.di.DatabaseModule
import ru.alexandrorlov.avito_test.data.network.di.NetworkModule
import ru.alexandrorlov.avito_test.feature.authentication.data.source.AuthApi
import ru.alexandrorlov.avito_test.feature.authentication.di.dependecies.AuthDependencies
import ru.alexandrorlov.avito_test.feature.registration.data.source.RegistrationApi
import ru.alexandrorlov.avito_test.feature.registration.di.dependecies.RegistrationDependencies

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        CommonModule::class,
    ]
)
@AppScope
interface AppComponent : RegistrationDependencies, AuthDependencies {

    override fun emailValidator(): EmailValidator

    override fun passwordValidator(): PasswordValidator

    override fun registrationApi(): RegistrationApi

    override fun authApi(): AuthApi

    override fun tokenDao(): TokenDao

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Context,
        ): AppComponent
    }
}