package ru.alexandrorlov.avito_test.feature.product_detail.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.alexandrorlov.avito_test.feature.product_detail.di.annotation.ViewModelKey
import ru.alexandrorlov.avito_test.feature.product_detail.di.bindmodule.ProductDetailRepositoryBindModule
import ru.alexandrorlov.avito_test.feature.product_detail.domain.repository.ProductDetailRepository
import ru.alexandrorlov.avito_test.feature.product_detail.ui.viewmodels.ProductDetailViewModel

@Module(includes = [
    ProductDetailRepositoryBindModule::class,
])
class ProductDetailModule {

    @[IntoMap Provides ViewModelKey(ProductDetailViewModel::class)]
    fun provideRegistrationViewModel(
        repository: ProductDetailRepository,
    ): ViewModel =
        ProductDetailViewModel(
            repository = repository,
        )
}