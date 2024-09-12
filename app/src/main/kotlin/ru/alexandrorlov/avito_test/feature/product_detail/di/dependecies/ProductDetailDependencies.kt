package ru.alexandrorlov.avito_test.feature.product_detail.di.dependecies

import ru.alexandrorlov.avito_test.feature.product_detail.data.source.ProductDetailApi

interface ProductDetailDependencies {

    fun productDetailApi(): ProductDetailApi

}