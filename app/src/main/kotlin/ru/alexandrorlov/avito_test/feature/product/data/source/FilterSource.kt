package ru.alexandrorlov.avito_test.feature.product.data.source

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListFilter
import javax.inject.Inject

@ProductScope
class FilterSource @Inject constructor() {
    private val _listFilter: MutableStateFlow<List<Filter>> =
        MutableStateFlow(value = fakeListFilter)
    private val listFilter: StateFlow<List<Filter>> = _listFilter.asStateFlow()

    fun getRemoteFilter(): Flow<List<Filter>> = listFilter

    suspend fun updateSelectedFilter(@StringRes idTitle: Int) {
        val changeListFilter: MutableList<Filter> = mutableListOf()

        _listFilter.value.forEach { it: Filter ->
            val filter: Filter = if (idTitle == it.idTitle) {
                it.copy(isSelected = it.isSelected.not())
            } else {
                it.copy(isSelected = false)
            }


            changeListFilter.add(filter)
        }

        _listFilter.emit(value = changeListFilter.toList())
    }
}