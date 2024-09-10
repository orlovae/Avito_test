package ru.alexandrorlov.avito_test.feature.product.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.feature.authentication.di.annotation.ViewModelKey
import ru.alexandrorlov.avito_test.feature.product.di.bindmodule.ProductListRepositoryBindModule
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.ProductListViewModel

@Module(includes = [
    ProductListRepositoryBindModule::class,
])
class ProductModule {

    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    @Provides
    fun provideRegistrationViewModel(
        repository: ProductListRepository,
    ): ViewModel =
        ProductListViewModel(
            repository = repository,
        )
}