package ru.alexandrorlov.avito_test.common.model

sealed class ScreenState<out T> {
    data object Loading : ScreenState<Nothing>()
    data class Content<T>(val content: T) : ScreenState<T>()
    data class Error(val message: String) : ScreenState<Nothing>()
}
