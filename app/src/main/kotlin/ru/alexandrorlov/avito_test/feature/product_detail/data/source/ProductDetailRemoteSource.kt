package ru.alexandrorlov.avito_test.feature.product_detail.data.source

import android.util.Log
import ru.alexandrorlov.avito_test.feature.product_detail.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product_detail.di.annotation.ProductDetailScope
import javax.inject.Inject

@ProductDetailScope
class ProductDetailRemoteSource @Inject constructor(private val api: ProductDetailApi) {

    suspend fun getRemoteData(idProduct: String): RemoteData {
        Log.d("OAE", "ProductDetailRemoteSource idProduct = $idProduct")
         val tmp = api.getRemoteData(idProduct = idProduct)
        Log.d("OAE", "ProductDetailRemoteSource tmp = $tmp")

        return tmp
    }
}