package ru.alexandrorlov.avito_test.feature.registration.domain.validators.api

import ru.alexandrorlov.avito_test.feature.registration.ui.models.viewstate.RegistrationViewState

interface AllDataValidator {
    fun valid(state: RegistrationViewState): Boolean
}