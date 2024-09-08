package ru.alexandrorlov.avito_test.feature.registration.domain.validators.impl

import ru.alexandrorlov.avito_test.feature.registration.domain.validators.api.NameValidator
import javax.inject.Inject

class NameValidatorImpl @Inject constructor(): NameValidator {
    override fun getShowErrorState(inputValue: String): Boolean = inputValue.isBlank()
}
