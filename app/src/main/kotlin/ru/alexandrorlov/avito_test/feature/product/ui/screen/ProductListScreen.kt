package ru.alexandrorlov.avito_test.feature.product.ui.screen

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.ContentScreen
import ru.alexandrorlov.avito_test.feature.product.ui.screen.component.HeaderScreen
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.CategoryViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.FilterViewModel
import ru.alexandrorlov.avito_test.feature.product.ui.viewmodel.ProductListViewModel
import ru.alexandrorlov.avito_test.navigation.Screen

@Composable
fun ProductListScreen(
    navController: NavHostController,
) {
    ProductListScreen(
        categoryViewModel = daggerViewModel(),
        filterViewModel = daggerViewModel(),
        productListViewModel = daggerViewModel(),
        navController = navController,
    )
}

@Composable
private fun ProductListScreen(
    categoryViewModel: CategoryViewModel,
    filterViewModel: FilterViewModel,
    productListViewModel: ProductListViewModel,
    navController: NavHostController,
) {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    val context: Context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        productListViewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {

                is SideEffect.SnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = sideEffect.message.asString(context = context),
                    )
                }
            }
        }
    }

    val stateCategoryComponent: ScreenState<List<Category>> =
        categoryViewModel.state.collectAsState().value

    val stateFilterComponent: ScreenState<List<Filter>> =
        filterViewModel.state.collectAsState().value

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
                stateCategory = stateCategoryComponent,
                stateFilter = stateFilterComponent,
                onSelectedCategory = { category: Category ->
                    categoryViewModel.onSelectedCategory.tryEmit(category.id)
                    productListViewModel.onSelectedCategory.tryEmit(category)
                },
                onSelectedFilter = { filter : Filter ->
                    filterViewModel.onSelectedFilter.tryEmit(filter.idTitle)
                    productListViewModel.onSelectedFilter.tryEmit(filter)
                }
            )

            ContentScreen(
                modifier = Modifier
                    .weight(3f),
                state = stateContentScreen,
                navigateToProductDetailScreen = { idProduct: String ->
                    navController.navigate(Screen.ProductDetail.createRouteWithArgs(
                        idProduct = idProduct)
                    )
                },
            )
        }
    }
}
