package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.PriceBlock
import ru.alexandrorlov.avito_test.common.ui.SpacerMediumPadding
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI

@Composable
internal fun ImageListRowAndTextSpecificationsBlock(
    product: ProductDetailUI,
) {
    val context: Context = LocalContext.current

    Column{
        LazyRow(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.small_padding))
        ) {
            items(product.urlPhotoList) { urlPhoto: String ->

                AsyncImage(
                    model = urlPhoto,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_product))
                        .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_card_product))),
                    error = painterResource(id = R.drawable.ic_launcher_error),
                    contentDescription = product.name,
                    contentScale = ContentScale.FillWidth,
                )
            }
        }

        SpacerSmallPadding()

        PriceBlock(
            discountedPrice = product.discountedPrice.asString(context = context),
            price = product.price.asString(context = context),
        )

        SpacerSmallPadding()

        TitleBlock(product = product)

        SpacerMediumPadding()

        SpecificationsComponent(product = product)
    }
}