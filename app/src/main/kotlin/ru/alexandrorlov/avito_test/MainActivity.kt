package ru.alexandrorlov.avito_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.alexandrorlov.avito_test.ui.screen.MainScreen
import ru.alexandrorlov.avito_test.ui.theme.Avito_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()

            Avito_testTheme {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        MainScreen(
                            navController = navController,
                        )
                    }
            }
        }
    }
}
