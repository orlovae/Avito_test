package ru.alexandrorlov.avito_test.feature.product_detail.di

import dagger.Component
import ru.alexandrorlov.avito_test.common.di.MultiViewModelFactory
import ru.alexandrorlov.avito_test.feature.product_detail.di.annotation.ProductDetailScope
import ru.alexandrorlov.avito_test.feature.product_detail.di.dependecies.ProductDetailDependencies

@Component(
    dependencies = [
        ProductDetailDependencies::class,
    ],
    modules = [ProductDetailModule::class]
)
@ProductDetailScope
interface ProductDetailComponent {

    fun getViewModelFactory(): MultiViewModelFactory

    @Component.Factory
    interface FeatureComponentFactory {
        fun create(
            dependencies: ProductDetailDependencies
        ): ProductDetailComponent
    }
}