package ru.alexandrorlov.avito_test.feature.product.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.domain.repository.HeaderRepository
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class HeaderViewModel @Inject constructor(
    private val repository: HeaderRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<List<Category>>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<Category>>> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    init {
        getAllCategory()
    }

    private fun getAllCategory() {
        viewModelScope.launch {
            kotlin.runCatching {
                val categoryList: List<Category> = repository.getAllCategory()

                _state.emit(ScreenState.Content(categoryList))
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
}
