package ru.alexandrorlov.avito_test.feature.product.data.source

import retrofit2.http.GET
import ru.alexandrorlov.avito_test.feature.product.data.models.RemoteData

interface ProductListApi {

    @GET("app/v1/products")
    suspend fun getRemoteData(): RemoteData
}