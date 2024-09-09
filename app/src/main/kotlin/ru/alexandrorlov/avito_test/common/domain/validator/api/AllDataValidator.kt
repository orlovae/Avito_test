package ru.alexandrorlov.avito_test.common.domain.validator.api

import ru.alexandrorlov.avito_test.common.model.state.ViewState

interface AllDataValidator {
    fun valid(state: ViewState): Boolean
}