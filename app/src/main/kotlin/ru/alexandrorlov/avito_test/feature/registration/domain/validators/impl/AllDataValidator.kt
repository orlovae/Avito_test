package ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl

import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.RegistrationViewState

class AllDataValidatorImpl : AllDataValidator {

    override fun valid(state: RegistrationViewState): Boolean =
        state.name.isErrorState || state.email.isErrorState ||
                state.password.isErrorState || state.confirmPassword.isErrorState
}