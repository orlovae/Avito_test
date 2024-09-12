package ru.alexandrorlov.avito_test.utils

import androidx.annotation.StringRes
import ru.alexandrorlov.avito_test.R
import java.text.DecimalFormat

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

fun addPostfixToPrice(
    value: Int?,
    @StringRes
    postfix: Int = R.string.ruble_sing,
): StringValue =
    if (value != null) {
        StringValue.StringResource(
            resId = postfix,
            args = value.groupingUsedToString(),
        )
    } else {
        StringValue.DynamicString("")
    }

fun Int.groupingUsedToString(): String =
    DecimalFormat().apply {
        isGroupingUsed = true
    }
        .format(this)
