package ru.alexandrorlov.avito_test.feature.product.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.ViewModelKey
import ru.alexandrorlov.avito_test.feature.product.di.bindmodule.ProductListRepositoryBindModule
import ru.alexandrorlov.avito_test.feature.product.domain.repository.CategoryRepository
import ru.alexandrorlov.avito_test.feature.product.domain.repository.FilterRepository
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.CategoryViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.FilterViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.ProductListViewModel

@Module(includes = [
    ProductListRepositoryBindModule::class,
])
class ProductListModule {

    @[IntoMap Provides ViewModelKey(FilterViewModel::class)]
    fun provideFilterViewModel(
        repository: FilterRepository,
    ): ViewModel =
        FilterViewModel(
            repository = repository,
        )

    @[IntoMap Provides ViewModelKey(CategoryViewModel::class)]
    fun provideCategoryViewModel(
        repository: CategoryRepository,
    ): ViewModel =
        CategoryViewModel(
            repository = repository,
        )

    @[IntoMap Provides ViewModelKey(ProductListViewModel::class)]
    fun provideRegistrationViewModel(
        repository: ProductListRepository,
    ): ViewModel =
        ProductListViewModel(
            repository = repository,
        )
}