package ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl

import ru.alexandrorlov.avito_test.common.domain.validator.api.AllDataValidator
import ru.alexandrorlov.avito_test.common.model.state.ViewState
import ru.alexandrorlov.avito_test.feature.registration.ui.models.RegistrationViewState
import javax.inject.Inject

class AllDataValidatorRegistrationImpl @Inject constructor(): AllDataValidator {

    override fun valid(viewState: ViewState): Boolean {
        val state: RegistrationViewState = viewState as RegistrationViewState
        return state.name.isErrorState || state.email.isErrorState ||
                state.password.isErrorState || state.confirmPassword.isErrorState
    }
}