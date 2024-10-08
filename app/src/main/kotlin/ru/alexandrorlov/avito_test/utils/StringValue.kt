package ru.alexandrorlov.avito_test.utils

import android.content.Context
import androidx.annotation.StringRes

sealed class StringValue {

    data class DynamicString(val value: String) : StringValue()

    class StringResource(
        @StringRes val resId: Int,
        val args: String = "",
        val isArgsFirst: Boolean = true,
    ) : StringValue()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> {
                if (args.isBlank()) {
                    context.getString(resId)
                } else {
                    getStringWithArgs(isArgsFirst, resId, args, context)
                }
            }
        }
    }

    private fun getStringWithArgs(
        isArgsFirst: Boolean,
        @StringRes resId: Int,
        args: String,
        context: Context): String =
        if (isArgsFirst) {
            "$args ${context.getString(resId)}"
        } else {
            "${context.getString(resId)} $args"
        }
}