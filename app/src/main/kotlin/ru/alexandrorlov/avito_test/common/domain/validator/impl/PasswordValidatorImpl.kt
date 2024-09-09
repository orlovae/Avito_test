package ru.alexandrorlov.avito_test.common.domain.validator.impl

import ru.alexandrorlov.avito_test.common.domain.validator.api.PasswordValidator
import ru.alexandrorlov.avito_test.common.model.state.Password
import javax.inject.Inject

class PasswordValidatorImpl @Inject constructor() : PasswordValidator {

    override fun inputValueTransformString(inputValue: String): String = inputValue

    override fun getShowErrorStateString(inputValue: String): Boolean = inputValue.isBlank()

    override fun validatePassword(inputValue: String): Password {
        val transformValue = inputValueTransformPassword(inputValue)
        val stayDigit = getStayDigitsPassword(inputValue)
        val showErrorStateValue = getShowErrorStatePassword(inputValue)
        return Password(
            value = transformValue,
            stayDigit = stayDigit,
            isErrorState = showErrorStateValue,
        )
    }

    private fun inputValueTransformPassword(inputValue: String): String =
        if (inputValue.length in 0..< MAX_CHARS_IN_PASSWORD) {
            inputValue
        } else {
            inputValue.substring(0..< MAX_CHARS_IN_PASSWORD)
        }

    private fun getStayDigitsPassword(inputValue: String): Int =
        if (MIN_CHARS_IN_PASSWORD - inputValue.length > 0) {
            MIN_CHARS_IN_PASSWORD - inputValue.length
        } else {
            0
        }

    private fun getShowErrorStatePassword(inputValue: String): Boolean =
        inputValue.length in 0..< MIN_CHARS_IN_PASSWORD

    override fun getShowErrorStateConfirmPassword(inputValue: String, password: String) =
        inputValue != password

    companion object {
        private const val MAX_CHARS_IN_PASSWORD = 24
        const val MIN_CHARS_IN_PASSWORD = 8
    }
}
