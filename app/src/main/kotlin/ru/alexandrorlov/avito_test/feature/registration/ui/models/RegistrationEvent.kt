package ru.alexandrorlov.avito_test.feature.registration.ui.models

sealed class RegistrationEvent {
    data object Init : RegistrationEvent()
    data object NavigateToAuthScreen : RegistrationEvent()
}