package ru.alexandrorlov.avito_test.feature.product.di

import dagger.Component
import ru.alexandrorlov.avito_test.common.di.MultiViewModelFactory
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.di.dependecies.ProductListDependencies

@Component(
    dependencies = [
        ProductListDependencies::class,
    ],
    modules = [ProductModule::class]
)
@ProductScope
interface ProductComponent {

    fun getViewModelFactory(): MultiViewModelFactory

    @Component.Factory
    interface FeatureComponentFactory {
        fun create(
            dependencies: ProductListDependencies
        ): ProductComponent
    }
}