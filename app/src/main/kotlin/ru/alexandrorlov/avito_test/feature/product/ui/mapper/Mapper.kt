package ru.alexandrorlov.avito_test.feature.product.ui.mapper

import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI

fun Product.toProductUI(): ProductUI =
    ProductUI(
        id = id,
        urlPhoto = urlPhoto,
        title = title,
        price = price,
        discountedPrice = discountedPrice,
        categoryList = categoryList,
    )
