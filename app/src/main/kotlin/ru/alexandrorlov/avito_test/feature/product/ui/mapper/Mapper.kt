package ru.alexandrorlov.avito_test.feature.product.ui.mapper

import androidx.annotation.StringRes
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.utils.StringValue

fun Product.toProductUI(): ProductUI =
    ProductUI(
        id = id,
        urlPhoto = urlPhoto,
        title = title,
        price = addPostfixToPrice(price),
        discountedPrice = addPostfixToPrice(discountedPrice),
        categoryList = categoryList,
    )

private fun addPostfixToPrice(
    value: String?,
    @StringRes
    postfix: Int = R.string.ruble_sing,
    ): StringValue =
    if (value != null) {
        StringValue.StringResource(
            resId = postfix,
            args = value,
        )
    } else {
        StringValue.DynamicString("")
    }
