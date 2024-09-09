package ru.alexandrorlov.avito_test.common.model.state

import ru.alexandrorlov.avito_test.common.domain.validator.impl.PasswordValidatorImpl.Companion.MIN_CHARS_IN_PASSWORD

data class Password(
    val value: String,
    val stayDigit: Int,
    val isErrorState: Boolean,
) {
    companion object {
        fun empty(): Password = Password(
            value = "",
            stayDigit = MIN_CHARS_IN_PASSWORD,
            isErrorState = true,
        )
    }
}
