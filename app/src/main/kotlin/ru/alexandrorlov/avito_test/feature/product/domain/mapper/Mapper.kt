package ru.alexandrorlov.avito_test.feature.product.domain.mapper

import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.feature.product.data.models.ProductRemote
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.utils.getStringValueFromString
import java.util.UUID

fun ProductRemote.toProduct(): Product =
    Product(
        id = setId(id = id),
        urlPhoto = getUrlImage(list = images),
        title = getStringValueFromString(name, R.string.product_no_name),
        price = price?.toString() ?: "",
        discountedPrice = discountedPrice?.toString() ?: "",
        categoryList = getCategoryListNotNull(category),
    )

private fun setId(id: String?): String =
    UUID.randomUUID().toString()

private fun getUrlImage(list: List<String?>): String =
    list
        .filterNotNull()
        .last()

private fun getCategoryListNotNull(list: List<String?>): List<String> =
    list.filterNotNull()
