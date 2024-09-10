package ru.alexandrorlov.avito_test.feature.product.di.dependecies

import ru.alexandrorlov.avito_test.feature.product.data.source.ProductListApi

interface ProductListDependencies {

    fun productListApi(): ProductListApi

}