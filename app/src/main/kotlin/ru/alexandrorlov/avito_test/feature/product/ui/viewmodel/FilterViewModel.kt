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
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.domain.repository.FilterRepository
import ru.alexandrorlov.avito_test.utils.getErrorMessage
import javax.inject.Inject

class FilterViewModel @Inject constructor(
    private val repository: FilterRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<ScreenState<List<Filter>>> =
        MutableStateFlow(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<Filter>>> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SideEffect> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    val onSelectedFilter: MutableSharedFlow<Int> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        getAllFilter()
        observerFilterList()
    }

    private fun getAllFilter() =
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getAllFilter()
                    .collect { filterList: List<Filter> ->
                        _state.emit(ScreenState.Content(filterList))
                    }
            }.getOrElse {
                _sideEffect.emit(
                    SideEffect.SnackBar(
                        message = it.message?.getErrorMessage() ?: "Unknown Error"
                    )
                )
            }
        }

    private fun observerFilterList() =
        onSelectedFilter
            .onEach { idTitle: Int ->
                repository.updateSelectedFilter(idTitle = idTitle)
            }
            .launchIn(viewModelScope)
}
