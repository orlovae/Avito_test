package ru.alexandrorlov.avito_test.feature.product_detail.domain.mapper

import ru.alexandrorlov.avito_test.feature.product_detail.data.models.ProductDetailRemote
import ru.alexandrorlov.avito_test.feature.product_detail.data.models.ProductSpecificationRemote
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductSpecification

internal fun ProductDetailRemote.toProductDetail(): ProductDetail =
    ProductDetail(
        brand = brand?: "",
        description = description?: "",
        discountedPrice = discountedPrice?.toString() ?: "",
        id = id?: "",
        urlPhotoList = urlPhotoList.map { urlPhoto: String? ->
            requireNotNull(urlPhoto)
        },
        name = name?: "",
        price = price?.toString() ?: "",
        productSpecifications = productSpecifications.map {
                productSpecificationRemote: ProductSpecificationRemote? ->
            requireNotNull(productSpecificationRemote).toProductSpecification()
        },
    )

internal fun ProductSpecificationRemote.toProductSpecification(): ProductSpecification =
    ProductSpecification(
        key = key?: "",
        value = value?: "",
    )