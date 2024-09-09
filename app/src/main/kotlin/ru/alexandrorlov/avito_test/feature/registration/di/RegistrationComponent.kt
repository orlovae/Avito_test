package ru.alexandrorlov.avito_test.feature.registration.di

import dagger.Component
import ru.alexandrorlov.avito_test.feature.authentication.di.MultiViewModelFactory
import ru.alexandrorlov.avito_test.feature.registration.di.dependecies.RegistrationDependencies

@Component(
    dependencies = [
        RegistrationDependencies::class,
    ],
    modules = [RegistrationModule::class]
)
@RegistrationScope
interface RegistrationComponent {

    fun getViewModelFactory(): MultiViewModelFactory

    @Component.Factory
    interface FeatureComponentFactory {
        fun create(
            registrationDependencies: RegistrationDependencies
        ): RegistrationComponent
    }
}