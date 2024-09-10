package ru.alexandrorlov.avito_test.feature.product.domain.repository

import ru.alexandrorlov.avito_test.feature.product.domain.models.Product

interface ProductListRepository {

    suspend fun getAllProduct(): List<Product>
}
