package ru.alexandrorlov.avito_test.feature.authentication.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun AuthScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
        ) {
        Text(
            text = "AuthScreen"
        )
    }

}

@Preview
@Composable
internal fun PreviewAuthScreen() {

}