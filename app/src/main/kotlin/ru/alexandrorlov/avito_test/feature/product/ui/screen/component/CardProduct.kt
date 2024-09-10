package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SpacerMediumPadding
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI
import ru.alexandrorlov.avito_test.ui.theme.BackgroundApp
import ru.alexandrorlov.avito_test.ui.theme.ProductText
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest
import ru.alexandrorlov.avito_test.utils.StringValue

@Composable
internal fun CardProduct(
    product: ProductUI,
    onClickProduct: (String) -> Unit,
) {
    val context: Context = LocalContext.current
    
    val price: String = product.price.asString(context = context)
    val discountedPrice: String = product.discountedPrice.asString(context = context)

    Card(
        modifier = Modifier,
        colors = CardColors(
            containerColor = BackgroundApp,
            contentColor = ProductText,
            disabledContainerColor = BackgroundApp,
            disabledContentColor = ProductText,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            AsyncImage(
                model = product.urlPhoto,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_product))
                    .clickable {
                        onClickProduct(product.id)
                    }
                    .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_card_product))),
                error = painterResource(id = R.drawable.ic_launcher_error),
                contentDescription = product.title.asString(context = context),
                contentScale = ContentScale.FillWidth,
            )

            SpacerMediumPadding()

            Text(
                text = product.title.asString(context = context),
                style = MaterialTheme.TypographyAvitoTest.textTitleProduct,
            )

            SpacerMediumPadding()

            if (discountedPrice.isNotBlank()) {
                Text(
                    text = product.discountedPrice.asString(context = context),
                    style = MaterialTheme.TypographyAvitoTest.textDiscountedPriceProduct,
                )
                
                if (price.isNotBlank()) {
                    Text(
                        text = product.price.asString(context = context),
                        style = MaterialTheme.TypographyAvitoTest.textPriceProduct,
                    )
                }
            }

            SpacerMediumPadding()
        }
    }
}

@Preview
@Composable
private fun CardProductPreview() {
    CardProduct(
        product = ProductUI(
            id = "1ase",
            urlPhoto = "",
            title = StringValue.DynamicString("Женские сапоги"),
            price = StringValue.DynamicString("9999 \u20BD"),
            discountedPrice = StringValue.DynamicString("1000 \u20BD"),
            categoryList = emptyList(),
        ),
        onClickProduct = { },
    )
}
