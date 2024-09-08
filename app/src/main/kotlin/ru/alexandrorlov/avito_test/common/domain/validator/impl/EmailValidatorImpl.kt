package ru.alexandrorlov.avito_test.common.domain.validator.impl

import android.util.Patterns.EMAIL_ADDRESS
import ru.alexandrorlov.avito_test.common.domain.validator.api.EmailValidator
import java.util.regex.Pattern
import javax.inject.Inject

class EmailValidatorImpl @Inject constructor () : EmailValidator {

    override val pattern: Pattern
        get() = EMAIL_ADDRESS

    override fun validateEmail(inputValue: String): Boolean =
        inputValue
            .matches(pattern.toRegex())
            .not()
}
