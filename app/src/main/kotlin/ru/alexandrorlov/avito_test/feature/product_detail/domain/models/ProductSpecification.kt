package ru.alexandrorlov.avito_test.feature.product_detail.domain.models

data class ProductSpecification(
    val key: String,
    val value: String,
) {
    companion object {
        fun empty(): ProductSpecification =
            ProductSpecification(
                key = "",
                value = "",
            )
    }
}