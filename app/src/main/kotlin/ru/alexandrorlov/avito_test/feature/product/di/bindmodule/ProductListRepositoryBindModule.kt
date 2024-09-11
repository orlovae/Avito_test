package ru.alexandrorlov.avito_test.feature.product.di.bindmodule

import dagger.Binds
import dagger.Module
import ru.alexandrorlov.avito_test.feature.product.data.repository.CategoryRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product.data.repository.FilterRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product.data.repository.ProductListRepositoryImpl
import ru.alexandrorlov.avito_test.feature.product.domain.repository.CategoryRepository
import ru.alexandrorlov.avito_test.feature.product.domain.repository.FilterRepository
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository

@Module
interface ProductListRepositoryBindModule {

    @Binds
    fun bindFilterRepositoryImplToFilterRepository(
        filterRepositoryImpl: FilterRepositoryImpl
    ): FilterRepository

    @Binds
    fun bindHeaderRepositoryImplToHeaderRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    fun bindProductListRepositoryImplToProductListRepository(
        productListRepositoryImpl: ProductListRepositoryImpl
    ): ProductListRepository

}