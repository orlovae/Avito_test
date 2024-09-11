package ru.alexandrorlov.avito_test.feature.product.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.ui.models.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.ContentScreen
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.HeaderScreen
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.HeaderViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.ProductListViewModel

@Composable
fun ProductListScreen(
    navigateToProductDetailScreen: (String) -> Unit,
) {
    ProductListScreen(
        headerViewModel = daggerViewModel(),
        productListViewModel = daggerViewModel(),
        navigateToProductDetailScreen = navigateToProductDetailScreen,
    )
}

@Composable
private fun ProductListScreen(
    headerViewModel: HeaderViewModel,
    productListViewModel: ProductListViewModel,
    navigateToProductDetailScreen: (String) -> Unit,
) {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = Unit) {
        productListViewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {

                is SideEffect.SnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = sideEffect.message,
                    )
                }
            }
        }
    }

    val stateHeaderScreen: ScreenState<List<Category>> =
        headerViewModel.state.collectAsState().value

    val stateContentScreen: ScreenState<List<ProductUI>> =
        productListViewModel.state.collectAsState().value

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                SnackbarAvitoTest(
                    snackBarText = data.visuals.message,
                )
            }
        },
    ) { innerPadding: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
        ) {
            HeaderScreen(
                modifier = Modifier
                    .weight(1f),
                state = stateHeaderScreen,
                onSelectedCategory = { category: Category ->
                    headerViewModel.onSelectedCategory.tryEmit(category.id)
                    productListViewModel.onSelectedCategory.tryEmit(category.title)
                },
                onSelectedFilter = { filter: Filter ->
                    productListViewModel.onSelectedFilter.tryEmit((filter))
                }
            )

            ContentScreen(
                modifier = Modifier
                    .weight(3f),
                state = stateContentScreen,
                navigateToProductDetailScreen = navigateToProductDetailScreen,
            )
        }
    }
}
