package ru.alexandrorlov.avito_test.feature.product_detail.data.source

import ru.alexandrorlov.avito_test.feature.product_detail.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product_detail.di.annotation.ProductDetailScope
import javax.inject.Inject

@ProductDetailScope
class ProductDetailRemoteSource @Inject constructor(private val api: ProductDetailApi) {

    suspend fun getRemoteData(idProduct: String): RemoteData =
        api.getRemoteData(idProduct = idProduct)
}