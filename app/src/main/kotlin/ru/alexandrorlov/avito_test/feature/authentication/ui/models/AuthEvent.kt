package ru.alexandrorlov.avito_test.feature.authentication.ui.models

sealed class AuthEvent {
    data object Init : AuthEvent()
    data object NavigateToProductListScreen : AuthEvent()
}