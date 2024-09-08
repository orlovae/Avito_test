package ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl

import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.SmsCodeValidator
import ru.alexandrorlov.avito_test.utils.isAllCharsDigits

class SmsCodeValidatorImpl : SmsCodeValidator {
    override val pattern: String
        get() = REGEX_SMS_CODE

    override fun inputValueTransform(inputValue: String): String =
        if (Regex(pattern).matches(inputValue)) {
            inputValue
        } else {
            getStringTransform(inputValue)
        }

    override fun getStayDigits(inputValue: String) = MAX_CHARS_IN_SMS_CODE - inputValue.length

    override fun getShowErrorState(inputValue: String): Boolean = inputValue.length in 0..<MAX_CHARS_IN_SMS_CODE

    private fun getStringTransform(inputString: String) =
        if (inputString.isAllCharsDigits()) {
            inputString.substring(0..<MAX_CHARS_IN_SMS_CODE)
        } else {
            inputString.dropLast(1)
        }

    companion object {
        private const val REGEX_SMS_CODE = "[0-9]{0,6}"
        private const val MAX_CHARS_IN_SMS_CODE = 6
    }
}
