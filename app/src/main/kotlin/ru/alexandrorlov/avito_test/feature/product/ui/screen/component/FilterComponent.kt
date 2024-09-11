package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter

@Composable
internal fun FilterComponent(
    modifier: Modifier,
    stateFilter: ScreenState<List<Filter>>,
    onSelectedFilter: (Filter) -> Unit,
) {
    when (stateFilter) {
        Loading -> { LoadingScreen(modifier = modifier) }

        is Content -> {

            Column(modifier = modifier) {
                LazyRow(
                    modifier = Modifier
                ) {
                    items(stateFilter.content) { filter: Filter ->
                        FilterView(
                            filter = filter,
                            onSelected = {
                                onSelectedFilter(filter)
                            },
                        )
                    }
                }
            }
        }

        is Error -> {
            Log.d("OAE", "Error ${stateFilter.message}")
        }
    }
}

@Preview
@Composable
private fun FilterComponentScreenStateLoadingPreview() {
    FilterComponent(
        modifier = Modifier,
        stateFilter = Loading,
        onSelectedFilter = {  },
    )
}

@Preview
@Composable
private fun FilterComponentScreenStateContentPreview() {
    FilterComponent(
        modifier = Modifier,
        stateFilter = Content(
            content = listOf(
                Filter(
                    idTitle = R.string.price_up_filter,
                    query = Filter.QUERY_PRICE_UP,
                ),
                Filter(
                    idTitle = R.string.price_down_filter,
                    query = Filter.QUERY_PRICE_DOWN,
                    isSelected = true,
                ),
            )
        ),
        onSelectedFilter = {  },
    )
}
