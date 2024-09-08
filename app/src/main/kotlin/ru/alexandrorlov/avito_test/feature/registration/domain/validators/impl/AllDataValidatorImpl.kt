package ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl

import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.AllDataValidator
import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.RegistrationViewState
import javax.inject.Inject

class AllDataValidatorImpl @Inject constructor(): AllDataValidator {

    override fun valid(state: RegistrationViewState): Boolean =
        state.name.isErrorState || state.email.isErrorState ||
                state.password.isErrorState || state.confirmPassword.isErrorState
}