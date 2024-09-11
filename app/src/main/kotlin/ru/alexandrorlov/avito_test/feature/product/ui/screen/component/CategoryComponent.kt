package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListCategory

@Composable
internal fun CategoryComponent(
    modifier: Modifier,
    stateCategory: ScreenState<List<Category>>,
    onSelectedCategory: (Category) -> Unit,
) {
    when (stateCategory) {
        Loading -> { LoadingScreen(modifier = modifier) }

        is Content -> {

            Column(modifier = modifier) {
                LazyHorizontalStaggeredGrid(
                    rows = StaggeredGridCells.Fixed(1),
                    contentPadding = PaddingValues(dimensionResource(id = R.dimen.small_padding)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding)),
                    horizontalItemSpacing = dimensionResource(id = R.dimen.small_padding),
                ) {
                    items(stateCategory.content) { category: Category ->

                        CategoryView(
                            category = category,
                            onSelectedCategory = {
                                onSelectedCategory(category)
                            },
                        )
                    }
                }
            }
        }

        is Error -> {
            Log.d("OAE", "Error ${stateCategory.message}")
        }
    }
}

@Preview
@Composable
private fun CategoryComponentScreenStateLoadingPreview() {
    CategoryComponent(
        modifier = Modifier,
        stateCategory = Loading,
        onSelectedCategory = { },
    )
}

@Preview
@Composable
private fun CategoryComponentScreenStateContentPreview() {
    CategoryComponent(
        modifier = Modifier
            .wrapContentHeight(),
        stateCategory = Content(fakeListCategory),
        onSelectedCategory = { },
    )
}
