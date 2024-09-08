package ru.alexandrorlov.avito_test.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography()

data class TypographyAvitoTest(
    val titleTopbar: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
    val titleBottombar: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 7.sp,
    ),
    val textButton: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
    ),
    val textField: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        color = Color.White,
    ),
    val footerTextInTextFiled: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 13.sp,
        color = RedText,
    ),


    val titleCell: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-1).sp,
    ),
    val noteCell: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)

val LocalTextStyle = staticCompositionLocalOf { TypographyAvitoTest() }

val MaterialTheme.TypographyAvitoTest
    @Composable
    @ReadOnlyComposable
    get() = LocalTextStyle.current