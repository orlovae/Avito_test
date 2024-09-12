package ru.alexandrorlov.avito_test.feature.product_detail.domain.mapper

import ru.alexandrorlov.avito_test.feature.product_detail.data.models.ProductDetailRemote
import ru.alexandrorlov.avito_test.feature.product_detail.data.models.SpecificationRemote
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.Specification
import ru.alexandrorlov.avito_test.utils.addPostfixToPrice

internal fun ProductDetailRemote.toProductDetail(): ProductDetail =
    ProductDetail(
        brand = brand?: "",
        description = description?: "",
        discountedPrice = addPostfixToPrice(discountedPrice),
        id = id?: "",
        urlPhotoList = urlPhotoList.map { urlPhoto: String? ->
            requireNotNull(urlPhoto)
        },
        name = name?: "",
        price = addPostfixToPrice(price),
        specifications = specifications.map {
                specificationRemote: SpecificationRemote? ->
            requireNotNull(specificationRemote).toProductSpecification()
        },
    )

private fun SpecificationRemote.toProductSpecification(): Specification =
    Specification(
        key = key?: "",
        value = value?: "",
    )