package ru.alexandrorlov.avito_test.feature.product.data.repository

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.data.source.FilterSource
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.domain.repository.FilterRepository
import javax.inject.Inject

@ProductScope
class FilterRepositoryImpl @Inject constructor(
    private val localSource: FilterSource,
) : FilterRepository {

    override suspend fun getAllFilter(): Flow<List<Filter>> =
        localSource.getRemoteFilter()

    override suspend fun updateSelectedFilter(@StringRes idTitle: Int) {
        localSource.updateSelectedFilter(idTitle = idTitle)
    }

}
