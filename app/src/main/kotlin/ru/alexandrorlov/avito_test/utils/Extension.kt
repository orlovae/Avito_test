package ru.alexandrorlov.avito_test.utils

import androidx.annotation.StringRes

fun getStringValueFromString(value: String, @StringRes stringId: Int): StringValue =
    if (value.isBlank()) {
        StringValue.StringResource(stringId)
    } else {
        StringValue.DynamicString(value)
    }

fun String.isAllCharsDigits() =
    if (this.isNotEmpty()) {
        this.all { char ->
            char.isDigit()
        }
    } else {
        false
    }