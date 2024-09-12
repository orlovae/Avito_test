package ru.alexandrorlov.avito_test.utils

import androidx.annotation.StringRes

fun getStringValueFromString(value: String?, @StringRes stringId: Int): StringValue =
    if (value.isNullOrBlank()) {
        StringValue.StringResource(stringId)
    } else {
        StringValue.DynamicString(value)
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
