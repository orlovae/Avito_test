package ru.alexandrorlov.avito_test.common.domain.validator.api

import java.util.regex.Pattern

interface EmailValidator {
    val pattern: Pattern
    fun validateEmail(inputValue: String): Boolean
}
