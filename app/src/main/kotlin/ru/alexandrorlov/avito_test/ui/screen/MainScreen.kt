package ru.alexandrorlov.avito_test.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.alexandrorlov.avito_test.navigation.BottomNavigationBar
import ru.alexandrorlov.avito_test.navigation.NavGraph

@Composable
internal fun MainScreen(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            NavGraph(
                navController = navController,
                startDestination = "productDetail/64d7e740e03347cdf0b560d5",
//                startDestination = Screen.Registration.route(),
            )
        }
    }
}