package ru.alexandrorlov.avito_test.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class ShapesAvitoTest(
    val shapeButton: Shape = RoundedCornerShape(
        size = 16.dp,
    ),

    val shapeTextField: Shape = RoundedCornerShape(
        size = 8.dp,
    ),

    val shapeSnackbar: Shape = RoundedCornerShape(
        size = 30.dp,
    ),
)

val LocalShapes = staticCompositionLocalOf { ShapesAvitoTest() }

val MaterialTheme.ShapesAvitoTest
    @Composable
    @ReadOnlyComposable
    get() = LocalShapes.current
