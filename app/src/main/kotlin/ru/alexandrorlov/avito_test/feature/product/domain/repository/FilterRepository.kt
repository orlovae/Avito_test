package ru.alexandrorlov.avito_test.feature.product.domain.repository

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter

interface FilterRepository {

    suspend fun getAllFilter(): Flow<List<Filter>>

    suspend fun updateSelectedFilter(@StringRes idTitle: Int)

}
