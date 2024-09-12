package ru.alexandrorlov.avito_test.feature.product_detail.ui.mapper

import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.Specification
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.SpecificationUI

internal fun ProductDetail.toProductDetailUI(): ProductDetailUI =
    ProductDetailUI(
        brand = brand,
        description = description,
        discountedPrice = discountedPrice,
        id = id,
        urlPhotoList = urlPhotoList,
        name = name,
        price = price,
        specifications = specifications.map {
                specification: Specification ->
            specification.toProductSpecificationUI()
        },
    )

private fun Specification.toProductSpecificationUI(): SpecificationUI =
    SpecificationUI(
        key = key,
        value = value,
    )