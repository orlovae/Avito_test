package ru.alexandrorlov.avito_test.feature.product.data.source

import ru.alexandrorlov.avito_test.feature.product.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import javax.inject.Inject

@ProductScope
class ProductRemoteSource @Inject constructor(private val api: ProductListApi) {

    suspend fun getRemoteData(): RemoteData = api.getRemoteData()
}