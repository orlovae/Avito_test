package ru.alexandrorlov.avito_test.feature.product_detail.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.product_detail.data.repository.ProductDetailRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product_detail.domain.repository.ProductDetailRepository

@Module
interface ProductDetailRepositoryBindModule {

    @Binds
    fun bindProductDetailRepositoryImplToProductDetailRepository(
        productDetailRepositoryImpl: ProductDetailRepositoryImpl
    ): ProductDetailRepository

}