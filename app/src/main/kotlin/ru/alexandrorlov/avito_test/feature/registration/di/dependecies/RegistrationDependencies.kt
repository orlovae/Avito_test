package ru.alexandrorlov.avito_test.feature.registration.di.dependecies

import ru.alexandrorlov.avito_test.feature.registration.data.RegistrationApi

interface RegistrationDependencies {

    fun registrationApi(): RegistrationApi

}