package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.ui.fakeFilter
import ru.alexandrorlov.avito_test.feature.product.ui.models.Filter

@Composable
internal fun HeaderScreen(
    modifier: Modifier,
    state: ScreenState<List<Category>>,
    onSelectedCategory: (Category) -> Unit,
    onSelectedFilter: (Filter) -> Unit,
) {
    when (state) {
        Loading -> { LoadingScreen(modifier = modifier) }

        is Content -> {

            Column(modifier = modifier) {
                LazyHorizontalStaggeredGrid(
                    rows = StaggeredGridCells.Fixed(1),
                    modifier = Modifier
                        .weight(5f),
                    contentPadding = PaddingValues(dimensionResource(id = R.dimen.small_padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding)),
                    horizontalItemSpacing = dimensionResource(id = R.dimen.small_padding),
                ) {
                    items(state.content) { category: Category ->

                        CategoryView(
                            category = category,
                            onSelectedCategory = {
                                onSelectedCategory(category)
                            },
                        )
                    }
                }

                SpacerSmallPadding()

                LazyRow(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    items(fakeFilter) { filter: Filter ->
                        FilterView(
                            title = stringResource(id = filter.titleId),
                            onSelected = {
                                onSelectedFilter(filter)
                            },
                        )
                    }
                }
            }
        }

        is Error -> {
            Log.d("OAE", "Error ${state.message}")
        }
    }
}