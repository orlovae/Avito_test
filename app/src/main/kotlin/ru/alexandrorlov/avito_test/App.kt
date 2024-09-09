package ru.alexandrorlov.avito_test

import android.app.Application
import ru.alexandrorlov.avito_test.di.AppComponent
import ru.alexandrorlov.avito_test.di.DaggerAppComponent
import ru.alexandrorlov.avito_test.feature.authentication.di.AuthComponent
import ru.alexandrorlov.avito_test.feature.authentication.di.DaggerAuthComponent
import ru.alexandrorlov.avito_test.feature.registration.di.DaggerRegistrationComponent
import ru.alexandrorlov.avito_test.feature.registration.di.RegistrationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
        registrationComponent = DaggerRegistrationComponent.factory().create(
            registrationDependencies = appComponent,
        )
        authComponent = DaggerAuthComponent.factory().create(
            authDependencies = appComponent,
        )
    }

    companion object {
        private lateinit var appComponent: AppComponent
        lateinit var registrationComponent: RegistrationComponent
        lateinit var authComponent: AuthComponent
    }
}
