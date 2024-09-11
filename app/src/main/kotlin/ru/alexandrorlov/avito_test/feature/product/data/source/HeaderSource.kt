package ru.alexandrorlov.avito_test.feature.product.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.di.annotation.ProductScope
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListCategory
import javax.inject.Inject

@ProductScope
class HeaderSource @Inject constructor() {
    private val _listCategory: MutableStateFlow<List<Category>> =
        MutableStateFlow(value = fakeListCategory)
    private val listCategory: StateFlow<List<Category>> = _listCategory.asStateFlow()

    fun getRemoteCategory(): Flow<List<Category>> = listCategory

    suspend fun updateSelectedCategory(idCategory: Int) {
        val changeListCategory: MutableList<Category> = mutableListOf()

        _listCategory.value.forEach { it: Category ->
            val category: Category = if (idCategory == it.id) {
                it.copy(isSelected = it.isSelected.not())
            } else {
                it.copy(isSelected = false)
            }


            changeListCategory.add(category)
        }

        _listCategory.emit(value = changeListCategory.toList())
    }
}