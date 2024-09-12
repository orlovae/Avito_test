package ru.alexandrorlov.avito_test.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.alexandrorlov.avito_test.App
import ru.alexandrorlov.avito_test.di.Inject
import ru.alexandrorlov.avito_test.feature.authentication.ui.screen.AuthScreen
import ru.alexandrorlov.avito_test.feature.product.ui.screen.ProductListScreen
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.ProductDetailScreen
import ru.alexandrorlov.avito_test.feature.registration.ui.screen.RegistrationScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(
            route = Screen.Registration.route(),
        ) {
            Inject(
                viewModelFactory = App.registrationComponent.getViewModelFactory()
            ) {
                RegistrationScreen(navController = navController)
            }
        }

        composable(
            route = Screen.Auth.route(),
        ) {
            Inject(
                viewModelFactory = App.authComponent.getViewModelFactory()
            ) {
                AuthScreen(navController = navController)
            }
        }

        composable(
            route = Screen.ProductList.route(),
        ) {
            Inject(
                viewModelFactory = App.productListComponent.getViewModelFactory()
            ) {
                ProductListScreen(navController = navController)
            }
        }

        composable(
            route = Screen.ProductDetail.route(),
            arguments = listOf(navArgument(Screen.ID_ARG_NAME) { type = NavType.StringType }),
        ) { navBackStackEntry: NavBackStackEntry ->

            val arguments: Bundle = requireNotNull(navBackStackEntry.arguments)
            val idProduct = arguments.getString(Screen.ID_ARG_NAME, "")

            Inject(
                viewModelFactory = App.productDetailComponent.getViewModelFactory()
            ) {
                ProductDetailScreen(
                    idProduct = idProduct,
                    navController = navController,
                )
            }
        }
    }
}
