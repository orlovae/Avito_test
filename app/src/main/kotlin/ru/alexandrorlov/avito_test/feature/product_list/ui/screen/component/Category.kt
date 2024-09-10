package ru.alexandrorlov.avito_test.feature.product_list.ui.screen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.BackgroundTextField
import ru.alexandrorlov.avito_test.ui.theme.CategoryText
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun Category(
    title: String,
    urlPhoto: String,
    onClickCategory: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_radius))),
        colors = CardColors(
            containerColor = BackgroundTextField,
            contentColor = CategoryText,
            disabledContainerColor = BackgroundTextField,
            disabledContentColor = CategoryText,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.medium_padding),
                        vertical = dimensionResource(id = R.dimen.x_x_small_padding),
                    ),
                text = title,
                style = MaterialTheme.TypographyAvitoTest.textCategory,
            )

            AsyncImage(
                model = urlPhoto,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickCategory()
                    },
                error = painterResource(id = R.drawable.ic_launcher_error),
                contentDescription = title,
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@Preview
@Composable
private fun CategoryPreview() {
    Category(
        title = "Одежда",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=f239fd141d2fa1a8ebd4e6d845d7136115ff9198f84a1213-12666658-images-thumbs&n=13",
        onClickCategory = {  }
    )
}