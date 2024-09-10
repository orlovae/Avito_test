package ru.alexandrorlov.avito_test.feature.product_list.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product_list.ui.Category
import ru.alexandrorlov.avito_test.feature.product_list.ui.Filter
import ru.alexandrorlov.avito_test.feature.product_list.ui.fakeFilter
import ru.alexandrorlov.avito_test.feature.product_list.ui.fakeListCategory
import ru.alexandrorlov.avito_test.feature.product_list.ui.screen.component.Category
import ru.alexandrorlov.avito_test.feature.product_list.ui.screen.component.Filter

@Composable
internal fun ProductListScreen(

) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                SnackbarAvitoTest(
                    snackBarText = data.visuals.message,
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
        ) {
            LazyHorizontalStaggeredGrid(
                rows = StaggeredGridCells.Fixed(1),
                modifier = Modifier
                    .weight(5f),
                contentPadding = PaddingValues(dimensionResource(id = R.dimen.small_padding)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding)),
                horizontalItemSpacing = dimensionResource(id = R.dimen.small_padding),
            ) {
                items(fakeListCategory) { item: Category ->
                    Category(
                        title = item.title,
                        urlPhoto = item.urlPhoto,
                        onClickCategory = { },
                    )

                }
            }

            SpacerSmallPadding()

            LazyRow(
                modifier = Modifier
                    .weight(1f),
            ) {
                items(fakeFilter) { item: Filter ->
                    Filter(
                        title = stringResource(id = item.titleId),
                        onSelected = {
                            //отправляем во вьюмодель нажатый фильтр - item.
                        },
                    )
                }
            }

            SpacerSmallPadding()

            Box(
                modifier = Modifier
                    .weight(10f)
                    .fillMaxSize()
                    .background(Color.Blue),
            ) {

            }
        }
    }

}

@Preview
@Composable
internal fun PreviewProductListScreen() {

}