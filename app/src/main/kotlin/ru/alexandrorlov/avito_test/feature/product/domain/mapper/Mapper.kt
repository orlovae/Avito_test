package ru.alexandrorlov.avito_test.feature.product.domain.mapper

import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.feature.product.data.models.ProductRemote
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.utils.addPostfixToPrice
import ru.alexandrorlov.avito_test.utils.getStringValueFromString
import java.util.UUID

fun ProductRemote.toProduct(): Product =
    Product(
        id = setId(id = id),
        urlPhoto = getUrlImageFromList(list = images),
        title = getStringValueFromString(name, R.string.product_no_name),
        price = addPostfixToPrice(price),
        discountedPrice = addPostfixToPrice(discountedPrice),
        categoryList = getCategoryListNotNull(category),
    )

private fun setId(id: String?): String =
    if (id.isNullOrBlank()) {
        UUID.randomUUID().toString()
    } else {
        id
    }

private fun getUrlImageFromList(list: List<String?>): String {
    val outList = list.filterNotNull()

    return if (outList.isNotEmpty()) outList.first() else ""
}

private fun getCategoryListNotNull(list: List<String?>): List<String> =
    list.filterNotNull()
