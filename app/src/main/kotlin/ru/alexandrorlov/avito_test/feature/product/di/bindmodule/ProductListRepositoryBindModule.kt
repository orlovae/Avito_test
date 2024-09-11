package ru.alexandrorlov.avito_test.feature.product.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.product.data.repository.HeaderRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product.data.repository.ProductListRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product.domain.repository.HeaderRepository
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository

@Module
interface ProductListRepositoryBindModule {

    @Binds
    fun bindHeaderRepositoryImplToHeaderRepository(
        headerRepositoryImpl: HeaderRepositoryImpl
    ): HeaderRepository

    @Binds
    fun bindProductListRepositoryImplToProductListRepository(
        productListRepositoryImpl: ProductListRepositoryImpl
    ): ProductListRepository

}