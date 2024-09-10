package ru.alexandrorlov.avito_test.feature.product.data.source

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexandrorlov.avito_test.feature.product.data.models.RemoteData

interface ProductListApi {

    @GET("app/v1/products")
    suspend fun getRemoteData(): RemoteData

    @GET("app/v1/products")
    suspend fun getRemoteDataByCategory(@Query("category") category: String): RemoteData

    @GET("app/v1/products{sort}")
    suspend fun sortRemoteDataByPrice(@Path("price") price: String): RemoteData
}