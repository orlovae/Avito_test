package ru.alexandrorlov.avito_test.feature.product_detail.domain.repository

import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail

interface ProductDetailRepository {

    suspend fun getProductDetail(idProduct: String): ProductDetail

}
