package ru.alexandrorlov.avito_test.common.domain.validator.api

import ru.alexandrorlov.avito_test.common.model.state.Password

interface PasswordValidator {
    fun inputValueTransformString(inputValue: String): String
    fun getShowErrorStateString(inputValue: String): Boolean
    fun validatePassword(inputValue: String): Password
    fun getShowErrorStateConfirmPassword(inputValue: String, password: String): Boolean
}
