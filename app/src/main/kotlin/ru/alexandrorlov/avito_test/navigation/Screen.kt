package ru.alexandrorlov.avito_test.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.alexandrorlov.avito_test.utils.Constant.ID_ARG_NAME

sealed class Screen {
    protected abstract val route: String
    abstract fun route(): String

    data object Registration : Screen() {

        override val route: String = "registration"

        override fun route(): String = route
    }

    data object Auth : Screen() {

        override val route: String = "auth"

        override fun route(): String = route
    }

    data object ProductList : Screen() {

        override val route: String = "productList"

        override fun route(): String = route
    }

    data object ProductDetail : Screen() {

        override val route: String = "productDetail"
        private const val idItem = ID_ARG_NAME

        override fun route(): String = "$route/{$idItem}"

        fun createRouteWithArgs(id: Long): String = "$route/$id"

        fun arguments(): List<NamedNavArgument> {
            return listOf(
                navArgument(idItem) { type = NavType.StringType }
            )
        }
    }

    companion object Constant {
        const val idItem = ID_ARG_NAME
    }
}