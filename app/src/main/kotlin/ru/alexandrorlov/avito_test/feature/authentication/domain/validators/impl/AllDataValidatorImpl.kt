package ru.alexandrorlov.avito_test.feature.authentication.domain.validators.impl

import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.common.model.state.ViewState
import ru.alexandrorlov.avito_test.feature.authentication.ui.models.AuthViewState
import javax.inject.Inject

class AllDataValidatorAuthImpl @Inject constructor(): AllDataValidator {

    override fun valid(viewState: ViewState): Boolean {
        val state: AuthViewState = viewState as AuthViewState
        return state.email.isErrorState || state.password.isErrorState
    }
}