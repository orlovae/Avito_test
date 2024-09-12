package ru.alexandrorlov.avito_test.feature.product_detail.data.repository

import ru.alexandrorlov.avito_test.feature.product_detail.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product_detail.data.source.ProductDetailRemoteSource
import ru.alexandrorlov.avito_test.feature.product_detail.di.annotation.ProductDetailScope
import ru.alexandrorlov.avito_test.feature.product_detail.domain.mapper.toProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.models.ProductDetail
import ru.alexandrorlov.avito_test.feature.product_detail.domain.repository.ProductDetailRepository
import javax.inject.Inject

@ProductDetailScope
class ProductDetailRepositoryImpl @Inject constructor(
    private val remoteSource: ProductDetailRemoteSource,
) : ProductDetailRepository {

    override suspend fun getProductDetail(idProduct: String): ProductDetail {
        val remoteData: RemoteData = remoteSource.getRemoteData(idProduct = idProduct)

        val productDetail: ProductDetail =
            remoteData.product?.toProductDetail() ?: ProductDetail.empty()

        return productDetail
    }
}
