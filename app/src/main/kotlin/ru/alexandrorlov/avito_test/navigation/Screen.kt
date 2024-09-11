package ru.alexandrorlov.avito_test.navigation

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

        override fun route(): String = "$route/{$ID_ARG_NAME}"

        fun createRouteWithArgs(idProduct: String): String = "$route/{$idProduct}"

    }

    companion object Constant {
        const val ID_ARG_NAME = "idProduct"
    }
}