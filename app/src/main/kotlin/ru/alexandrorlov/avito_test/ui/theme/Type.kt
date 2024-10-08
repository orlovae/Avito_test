package ru.alexandrorlov.avito_test.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

val Typography = Typography()

class TypographyAvitoTest(
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
    val textSnackbar: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 17.sp,
    ),
    val titleTopBar: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
    ),
    val textFilter: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
    ),
    val textCategory: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 12.sp,
    ),
    val textTitleProduct: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 12.sp,
    ),
    val textPriceProduct: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        textDecoration = TextDecoration.LineThrough,
        color = CategoryText,
    ),
    val textDiscountedPriceProduct: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        color = CategoryText,
    ),
    val textNameProductDetail: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        color = CategoryText,
    ),
    val textNameSpecificationProductDetail: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        color = CategoryText,
    ),
    val textKeySpecificationProductDetailSpanStyle: SpanStyle = SpanStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp,
        color = ValueSpecificationText,
    ),
    val textValueSpecificationProductDetailSpanStyle: SpanStyle = SpanStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp,
        color = CategoryText,
    ),
    val textValueSpecificationProductDetail: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp,
        color = CategoryText,
    ),
)

val LocalTextStyle = staticCompositionLocalOf { TypographyAvitoTest() }

val MaterialTheme.TypographyAvitoTest
    @Composable
    @ReadOnlyComposable
    get() = LocalTextStyle.current