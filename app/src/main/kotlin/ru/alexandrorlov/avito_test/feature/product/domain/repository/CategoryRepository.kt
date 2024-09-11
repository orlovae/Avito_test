package ru.alexandrorlov.avito_test.feature.product.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.avito_test.feature.product.data.models.Category

interface CategoryRepository {

    suspend fun getAllCategory(): Flow<List<Category>>

    suspend fun updateSelectedCategory(idCategory: Int)

}
