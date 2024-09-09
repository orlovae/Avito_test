package ru.alexandrorlov.avito_test.feature.authentication.ui.models

import ru.alexandrorlov.avito_test.common.model.state.Email
import ru.alexandrorlov.avito_test.common.model.state.Password
import ru.alexandrorlov.avito_test.common.model.state.ViewState

data class AuthViewState(
    val email: Email,
    val password: Password,
    val isAllDataNotValid: Boolean,
) : ViewState
