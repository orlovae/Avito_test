package ru.alexandrorlov.avito_test.feature.product.di

import dagger.Component
import ru.alexandrorlov.avito_test.di.MultiViewModelFactory
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductListScope
import ru.alexandrorlov.avito_test.feature.product.di.dependecies.ProductListDependencies

@Component(
    dependencies = [
        ProductListDependencies::class,
    ],
    modules = [ProductListModule::class]
)
@ProductListScope
interface ProductListComponent {

    fun getViewModelFactory(): MultiViewModelFactory

    @Component.Factory
    interface FeatureComponentFactory {
        fun create(
            dependencies: ProductListDependencies
        ): ProductListComponent
    }
}