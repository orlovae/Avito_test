package ru.alexandrorlov.avito_test.common.model

sealed class SideEffect {
    data class SnackBar(val message: String) : SideEffect()
}