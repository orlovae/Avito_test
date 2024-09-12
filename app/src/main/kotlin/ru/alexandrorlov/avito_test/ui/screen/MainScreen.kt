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
                startDestination = "productDetail/6500cb79202e8fd9c163a7fb",
//                startDestination = Screen.Registration.route(),
            )
        }
    }
}