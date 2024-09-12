package ru.alexandrorlov.avito_test.feature.authentication.di

import dagger.Component
import ru.alexandrorlov.avito_test.di.MultiViewModelFactory
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.AuthScope
import ru.alexandrorlov.avito_test.feature.authentication.di.dependecies.AuthDependencies

@Component(
    dependencies = [
        AuthDependencies::class,
    ],
    modules = [AuthModule::class]
)
@AuthScope
interface AuthComponent {

    fun getViewModelFactory(): MultiViewModelFactory

    @Component.Factory
    interface FeatureComponentFactory {
        fun create(
            dependencies: AuthDependencies
        ): AuthComponent
    }
}