package ru.alexandrorlov.avito_test.feature.registration.ui.models

import ru.alexandrorlov.avito_test.common.model.state.Email
import ru.alexandrorlov.avito_test.common.model.state.Password
import ru.alexandrorlov.avito_test.common.model.state.ViewState

data class RegistrationViewState(
    val name: Name,
    val email: Email,
    val password: Password,
    val confirmPassword: ConfirmPassword,
    val isAllDataNotValid: Boolean,
) : ViewState

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