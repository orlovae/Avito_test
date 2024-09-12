package ru.alexandrorlov.avito_test.feature.product_detail.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.feature.product_detail.domain.repository.ProductDetailRepository
import ru.alexandrorlov.avito_test.feature.product_detail.ui.mapper.toProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.utils.StringValue
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    private val repository: ProductDetailRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<ProductDetailUI>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<ProductDetailUI>> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val idProductDetail: MutableStateFlow<String> = MutableStateFlow("")

    val onClickButton: MutableSharedFlow<String> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        getProductDetail()
        observeOnClickButton()
    }

    private fun getProductDetail() =
        idProductDetail
            .onEach { idProduct: String ->
                if (idProduct.isNotBlank()) {
                    val product: ProductDetailUI =
                        repository.getProductDetail(idProduct = idProduct)
                            .toProductDetailUI()

                    _state.emit(ScreenState.Content(content = product))
                }
            }
            .catch {
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = StringValue.DynamicString(it.message?.getErrorMessage() ?: "Unknown Error")
                    )
                )
            }
            .launchIn(viewModelScope)

    private fun observeOnClickButton() =
        onClickButton
            .onEach {
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = StringValue.StringResource(resId = R.string.message_product_detail_list)
                    )
                )
            }
            .launchIn(viewModelScope)
}
