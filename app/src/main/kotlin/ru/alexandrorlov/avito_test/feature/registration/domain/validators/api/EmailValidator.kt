package ru.alexandrorlov.avito_test.feature.registration.domain.validators.api

import java.util.regex.Pattern

interface EmailValidator {
    val pattern: Pattern
    fun validateEmail(inputValue: String): Boolean
}
