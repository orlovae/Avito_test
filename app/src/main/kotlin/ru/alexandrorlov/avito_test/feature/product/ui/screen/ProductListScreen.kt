package ru.alexandrorlov.avito_test.feature.product.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.Category
import ru.alexandrorlov.avito_test.feature.product.ui.fakeFilter
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListCategory
import ru.alexandrorlov.avito_test.feature.product.ui.models.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.CardProduct
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.Category
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.ProductListViewModel

@Composable
fun ProductListScreen(
    navigateToProductDetailScreen: (String) -> Unit,
) {
    ProductListScreen(
        viewModel = daggerViewModel(),
        navigateToProductDetailScreen = navigateToProductDetailScreen,
    )
}

@Composable
private fun ProductListScreen(
    viewModel: ProductListViewModel,
    navigateToProductDetailScreen: (String) -> Unit,
) {
    val state: State<ScreenState<List<ProductUI>>> = viewModel.state.collectAsState()

    when (val data = state.value) {
        Loading -> {
            LoadingScreen()
        }

        is Content -> {

            val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

            LaunchedEffect(key1 = Unit) {
                viewModel.sideEffect.collect { sideEffect ->
                    when (sideEffect) {

                        is SideEffect.SnackBar -> {
                            snackbarHostState.showSnackbar(
                                message = sideEffect.message,
                            )
                        }
                    }
                }
            }

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
                                onSelectedCategory = {
                                    viewModel.onSelectedCategory.tryEmit(item.title)
                                },
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
                                    viewModel.onSelectedFilter.tryEmit(item)
                                },
                            )
                        }
                    }

                    SpacerSmallPadding()

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .weight(10f)
                            .fillMaxSize(),
//                        contentPadding = PaddingValues(dimensionResource(id = R.dimen.x_x_small_padding)),
                    ) {
                        items(data.content) { product: ProductUI ->
                            CardProduct(
                                product = product,
                                onClickProduct = {
                                    viewModel.onClickProduct.tryEmit(product.id)
                                }
                            )
                        }
                    }
                }
            }
        }

        is Error -> {
            Log.d("OAE", "Error ${data.message}")
        }
    }
}

@Preview
@Composable
internal fun PreviewProductListScreen() {

}