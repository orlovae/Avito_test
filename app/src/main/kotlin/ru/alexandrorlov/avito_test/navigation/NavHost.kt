package ru.alexandrorlov.avito_test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.alexandrorlov.avito_test.App
import ru.alexandrorlov.avito_test.di.Inject
import ru.alexandrorlov.avito_test.feature.authentication.ui.screen.AuthScreen
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.ProductDetailScreen
import ru.alexandrorlov.avito_test.feature.product_list.ui.screen.ProductListScreen
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
        ) { navBackStackEntry ->
            navBackStackEntry.destination
            Inject(
                viewModelFactory = App.registrationComponent.getViewModelFactory()
            ) {
                RegistrationScreen(
                    navigateToAuthScreen = {
                        navController.navigate(
                            Screen.Auth.route()
                        )
                    }
                )
            }
        }

        composable(
            route = Screen.Auth.route(),
        ) {
                navBackStackEntry ->
            navBackStackEntry.destination
            Inject(
                viewModelFactory = App.authComponent.getViewModelFactory()
            ) {
                AuthScreen(
                    navigateToScreen = {  },
                )
            }
        }

        composable(
            route = Screen.ProductList.route(),
//            arguments = Screen.ProductDetail.arguments()
        ) { navBackStackEntry ->
            navBackStackEntry.destination

            ProductListScreen(

            )
        }

        composable(
            route = Screen.ProductDetail.route(),
            arguments = listOf(navArgument(Screen.idItem) { type = NavType.LongType })
        ) {

            val arguments = requireNotNull(it.arguments)
            val id = arguments.getLong(Screen.idItem, -1L)

            ProductDetailScreen(

            )
        }
    }
}
