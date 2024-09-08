package ru.alexandrorlov.avito_test.feature.registration.domain.validators.api

interface SmsCodeValidator {
    val pattern: String
    fun inputValueTransform(inputValue: String): String
    fun getStayDigits(inputValue: String): Int
    fun getShowErrorState(inputValue: String): Boolean
}
