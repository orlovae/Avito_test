package ru.alexandrorlov.avito_test.common.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.ui.theme.BackgroundApp
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAvitoTest(
    title: String,
){
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.TypographyAvitoTest.titleTopBar,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = BackgroundApp,
            titleContentColor = Color.White,
            ),
    )
}

@Preview
@Composable
private fun TopBarAvitoTestPreview() {
    TopBarAvitoTest(
        title = "Top Bar Avito Test",
    )
}