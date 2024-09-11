package ru.alexandrorlov.avito_test.feature.product.data.models

data class Category(
    val id: Int,
    val title: String,
    val urlPhoto: String,
    val isSelected: Boolean,
)