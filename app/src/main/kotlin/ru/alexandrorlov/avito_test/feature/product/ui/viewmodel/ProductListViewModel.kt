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
import ru.alexandrorlov.avito_test.feature.product.domain.models.Product
import ru.alexandrorlov.avito_test.feature.product.domain.repository.ProductListRepository
import ru.alexandrorlov.avito_test.feature.product.ui.mapper.toProductUI
import ru.alexandrorlov.avito_test.feature.product.ui.models.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductListEvent
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val repository: ProductListRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<List<ProductUI>>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<ProductUI>>> = _state.asStateFlow()

    private val _event: MutableStateFlow<ProductListEvent> = MutableStateFlow(
        ProductListEvent.Init
    )
    val event: StateFlow<ProductListEvent> = _event.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val onSelectedCategory: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)
    val onSelectedFilter: MutableSharedFlow<Filter> = MutableSharedFlow(extraBufferCapacity = 1)
    val onClickProduct: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

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
                _state.emit(ScreenState.Content(productList))
            }.getOrElse {
//                _state.emit(ScreenState.Error(it.message ?: "ERROR"))
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
            .onEach {
                _state.emit(ScreenState.Loading)
            }
            .onEach { nameCategory: String ->
                getProductListFilerByCategory(category = nameCategory)
            }
            .launchIn(viewModelScope)

    private fun observeOnSelectedFilter() =
        onSelectedFilter
            .onEach { filter: Filter ->

            }
            .launchIn(viewModelScope)

    private fun observeOnClickProduct() =
        onClickProduct
            .onEach { idProduct: String ->

            }
            .launchIn(viewModelScope)

    private suspend fun getProductListFilerByCategory(category: String) =
            kotlin.runCatching {
                val productList: List<ProductUI> =
                    repository.getProductListByCategory(category = category)
                        .map { product: Product ->
                            product.toProductUI()
                        }
                _state.emit(ScreenState.Content(productList))
            }.getOrElse {
//                _state.emit(ScreenState.Error(it.message ?: "ERROR"))
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = it.message?.getErrorMessage() ?: "Unknown Error"
                    )
                )
            }
}
