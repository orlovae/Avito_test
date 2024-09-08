package ru.alexandrorlov.avito_test.feature.registration.domain.validators.api

interface NameValidator {
    fun getShowErrorState(inputValue: String): Boolean
}
