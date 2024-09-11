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
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository
import ru.alexandrorlov.avito_test.feature.product.ui.mapper.toProductUI
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val repository: ProductListRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<List<ProductUI>>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<ProductUI>>> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val onSelectedCategory: MutableSharedFlow<Category> = MutableSharedFlow(extraBufferCapacity = 1)
    val onSelectedFilter: MutableSharedFlow<Filter> = MutableSharedFlow(extraBufferCapacity = 1)
    val onClickProduct: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    private val _onSelectedTitleCategory: MutableStateFlow<String> =
        MutableStateFlow("")
    private val _onSelectedQueryFilter: MutableStateFlow<String> =
        MutableStateFlow("")

    init {
        getAllProduct()
        observeOnSelectedCategory()
        observeOnSelectedFilter()
        observeOnClickProduct()
    }

    private fun getAllProduct() {
        viewModelScope.launch {
            kotlin.runCatching {
                val productList: List<ProductUI> = repository.getAllProduct()
                    .map { product: Product ->
                        product.toProductUI()
                    }
                _state.emit(ScreenState.Content(content = productList))
            }.getOrElse {
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = it.message?.getErrorMessage() ?: "Unknown Error"
                    )
                )
            }
        }
    }

    private fun observeOnSelectedCategory() =
        onSelectedCategory
            .onEach { category: Category ->
                _onSelectedTitleCategory.emit(category.title)
            }
            .onEach {
                _state.emit(ScreenState.Loading)
            }
            .onEach { category: Category ->
                if (category.isSelected.not()) {
                    getProductListByCategory()
                } else {
                    getAllProduct()
                }
            }
            .launchIn(viewModelScope)

    private fun observeOnSelectedFilter() =
        onSelectedFilter
            .onEach { filter: Filter ->
                _onSelectedQueryFilter.emit(filter.query)
            }
            .onEach { filter: Filter ->
                if (filter.isSelected.not()) {
                    getProductListByCategory()
                } else {
                    getAllProduct()
                }
            }
            .launchIn(viewModelScope)

    private fun observeOnClickProduct() =
        onClickProduct
            .onEach { idProduct: String ->

            }
            .launchIn(viewModelScope)

    private suspend fun getProductListByCategory() =
        kotlin.runCatching {
            _state.emit(ScreenState.Loading)

            val queryFilter: String = _onSelectedQueryFilter.value
            val titleCategory: String = _onSelectedTitleCategory.value

            val productList: List<ProductUI> =
                repository.getProductListByCategory(
                    titleCategory = titleCategory,
                    queryFilter = queryFilter,
                )
                    .map { product: Product ->
                        product.toProductUI()
                    }
            _state.emit(ScreenState.Content(content = productList))
        }.getOrElse {
            _sideEffect.emit(
                SideEffect.SnackBar(
                    message = it.message?.getErrorMessage() ?: "Unknown Error"
                )
            )
        }
}
