package ru.alexandrorlov.avito_test.common.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.ShapesAvitoTest
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
fun SnackbarAvitoTest(
    snackBarText: String,
    bottomPadding: Int = R.dimen.small_snackbar_bottom_padding,
) {
    Snackbar(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.medium_padding),
                end = dimensionResource(id = R.dimen.medium_padding),
                bottom = dimensionResource(bottomPadding),
            )
            .border(
                width = dimensionResource(id = R.dimen.border_thickness_snackbar),
                color = Color.Black,
                shape = MaterialTheme.ShapesAvitoTest.shapeSnackbar,
            ),
        shape = MaterialTheme.ShapesAvitoTest.shapeSnackbar,
        containerColor = Color.White,
        contentColor = Color.Black,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = snackBarText,
            textAlign = TextAlign.Center,
            style = MaterialTheme.TypographyAvitoTest.textSnackbar,
        )
    }
}
