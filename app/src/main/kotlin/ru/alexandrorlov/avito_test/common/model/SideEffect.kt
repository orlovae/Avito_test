package ru.alexandrorlov.avito_test.common.model

import ru.alexandrorlov.avito_test.utils.StringValue

sealed class SideEffect {
    data class SnackBar(val message: StringValue) : SideEffect()
}