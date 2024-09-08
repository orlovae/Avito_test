package ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate

import ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl.PasswordValidatorImpl.Companion.MIN_CHARS_IN_PASSWORD

data class RegistrationViewState(
    val name: Name,
    val email: Email,
    val password: Password,
    val confirmPassword: ConfirmPassword,
    val isAllDataNotValid: Boolean,

    )

data class Name(
    val value: String,
    val isErrorState: Boolean,
) {
    companion object {
        fun empty(): Name = Name(
            value = "",
            isErrorState = true,
        )
    }
}

data class Email(
    val value: String,
    val isErrorState: Boolean,
) {
    companion object {
        fun empty(): Email = Email(
            value = "",
            isErrorState = true,
        )
    }
}

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

data class ConfirmPassword(
    val value: String,
    val isErrorState: Boolean,
) {
    companion object {
        fun empty(): ConfirmPassword = ConfirmPassword(
            value = "",
            isErrorState = true,
        )
    }
}