package ru.alexandrorlov.avito_test.common.model.state

data class Email(
    val value: String,
    val isErrorState: Boolean,
) {
    companion object {
        fun empty(): Email = Email(
            value = "",
            isErrorState = true,
        )
    }
}
