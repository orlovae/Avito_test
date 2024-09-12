package ru.alexandrorlov.avito_test.feature.product_detail.data.source

import retrofit2.http.GET
import retrofit2.http.Path
import ru.alexandrorlov.avito_test.feature.product_detail.data.models.RemoteData

interface ProductDetailApi {

    @GET("app/v1/products/{$ID}")
    suspend fun getRemoteData(@Path(ID) idProduct: String): RemoteData

    companion object{
        private const val ID = "id"
    }
}