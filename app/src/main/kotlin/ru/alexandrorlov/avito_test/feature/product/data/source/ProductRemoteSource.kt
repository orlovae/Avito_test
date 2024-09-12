package ru.alexandrorlov.avito_test.feature.product.data.source

import ru.alexandrorlov.avito_test.feature.product.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductListScope
import javax.inject.Inject

@ProductListScope
class ProductRemoteSource @Inject constructor(private val api: ProductListApi) {

    suspend fun getRemoteData(): RemoteData = api.getRemoteData()

    suspend fun getRemoteDataByCategory(titleCategory: String, queryFilter: String): RemoteData =
        api.getRemoteDataByCategory(
            category = titleCategory,
            price = queryFilter,
            )
}