package ru.alexandrorlov.avito_test.feature.registration.domain.validators.api

import ru.alexandrorlov.avito_test.feature.registration.ui.models.Password

interface PasswordValidator {
    fun inputValueTransformString(inputValue: String): String
    fun getShowErrorStateString(inputValue: String): Boolean
    fun validatePassword(inputValue: String): Password
    fun getShowErrorStateConfirmPassword(inputValue: String, password: String): Boolean
}
