package ru.alexandrorlov.avito_test.feature.product.data.repository

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.data.source.HeaderSource
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.domain.repository.HeaderRepository
import javax.inject.Inject

@ProductScope
class HeaderRepositoryImpl @Inject constructor(
    private val localSource: HeaderSource,
) : HeaderRepository {

    override suspend fun getAllCategory(): Flow<List<Category>> =
        localSource.getRemoteCategory()

    override suspend fun updateSelectedCategory(idCategory: Int) {
        localSource.updateSelectedCategory(idCategory = idCategory)
    }

}
