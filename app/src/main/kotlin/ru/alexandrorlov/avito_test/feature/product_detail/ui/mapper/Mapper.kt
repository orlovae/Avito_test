package ru.alexandrorlov.avito_test.feature.product_detail.ui.mapper

import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductSpecification
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductSpecificationUI

internal fun ProductDetail.toProductDetailUI(): ProductDetailUI =
    ProductDetailUI(
        brand = brand,
        description = description,
        discountedPrice = discountedPrice,
        id = id,
        urlPhotoList = urlPhotoList,
        name = name,
        price = price,
        productSpecifications = productSpecifications.map {
                productSpecification: ProductSpecification ->
            productSpecification.toProductSpecificationUI()
        },
    )

internal fun ProductSpecification.toProductSpecificationUI(): ProductSpecificationUI =
    ProductSpecificationUI(
        key = key,
        value = value,
    )