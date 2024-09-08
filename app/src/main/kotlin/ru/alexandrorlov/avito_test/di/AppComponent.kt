package ru.alexandrorlov.avito_test.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.alexandrorlov.avito_test.data.network.di.NetworkModule
import ru.alexandrorlov.avito_test.feature.registration.data.RegistrationApi
import ru.alexandrorlov.avito_test.feature.registration.di.dependecies.RegistrationDependencies

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
    ]
)
@AppScope
interface AppComponent : RegistrationDependencies {

    override fun registrationApi(): RegistrationApi

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Context,
        ): AppComponent
    }
}