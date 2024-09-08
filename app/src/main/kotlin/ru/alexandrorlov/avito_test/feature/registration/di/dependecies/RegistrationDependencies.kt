package ru.alexandrorlov.avito_test.feature.registration.di.dependecies

import ru.alexandrorlov.avito_test.feature.registration.data.source.RegistrationApi

interface RegistrationDependencies {

    fun registrationApi(): RegistrationApi

}