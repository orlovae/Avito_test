package ru.alexandrorlov.avito_test.feature.product.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.domain.repository.CategoryRepository
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<List<Category>>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<Category>>> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val onSelectedCategory: MutableSharedFlow<Int> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        getAllCategory()
        observerCategory()
    }

    private fun getAllCategory() =
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getAllCategory()
                    .collect { categoryList: List<Category> ->
                        _state.emit(ScreenState.Content(categoryList))
                    }
            }.getOrElse {
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = it.message?.getErrorMessage() ?: "Unknown Error"
                    )
                )
            }
        }

    private fun observerCategory() =
        onSelectedCategory
            .onEach { id: Int ->
                repository.updateSelectedCategory(idCategory = id)
            }
            .launchIn(viewModelScope)
}
