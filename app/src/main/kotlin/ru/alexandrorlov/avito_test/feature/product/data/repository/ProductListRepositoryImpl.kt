package ru.alexandrorlov.avito_test.feature.product.data.repository

import ru.alexandrorlov.avito_test.feature.product.data.models.ProductRemote
import ru.alexandrorlov.avito_test.feature.product.data.models.RemoteData
import ru.alexandrorlov.avito_test.feature.product.data.source.ProductRemoteSource
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.domain.mapper.toProduct
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository
import javax.inject.Inject

@ProductScope
class ProductListRepositoryImpl @Inject constructor(
    private val remoteSource: ProductRemoteSource,
) : ProductListRepository {

    override suspend fun getAllProduct(): List<Product> {
        val remoteData: RemoteData = remoteSource.getRemoteData()

        val productList: List<Product> = remoteData.productList
            .requireNoNulls()
            .map { product: ProductRemote ->
                product.toProduct()
            }

        return productList
    }

    override suspend fun getProductListByCategory(category: String): List<Product> {
        val remoteData: RemoteData = remoteSource.getRemoteDataByCategory(category = category)

        val productList: List<Product> = remoteData.productList
            .requireNoNulls()
            .map { product: ProductRemote ->
                product.toProduct()
            }

        return productList
    }

    override suspend fun getAllProductSortByPrice(price: String) {
        TODO("Not yet implemented")
    }
}
