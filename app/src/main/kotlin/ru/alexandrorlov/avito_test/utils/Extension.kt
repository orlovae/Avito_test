package ru.alexandrorlov.avito_test.utils

import androidx.annotation.StringRes

fun getStringValueFromString(value: String?, @StringRes stringId: Int): StringValue =
    if (value.isNullOrBlank()) {
        StringValue.StringResource(stringId)
    } else {
        StringValue.DynamicString(value)
    }

fun getStringValueFromString(value: Int?, @StringRes stringId: Int): StringValue =
    if (value != null) {
        StringValue.DynamicString(value.toString())
    } else {
        StringValue.StringResource(stringId)
    }

fun String.isAllCharsDigits() =
    if (this.isNotEmpty()) {
        this.all { char ->
            char.isDigit()
        }
    } else {
        false
    }

fun String.getErrorMessage(): String {
    val outFirst: StringBuilder = StringBuilder("Error ")

    val outLast: String = this
        .split(",")
        .last()
        .split(":")
        .last()
        .filter {
            it.isLetter() || it.isWhitespace()
        }

    return outFirst.append(outLast).toString()
}
