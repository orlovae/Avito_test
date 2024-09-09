package ru.alexandrorlov.avito_test.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.BackgroundButton
import ru.alexandrorlov.avito_test.ui.theme.LightGreyButton
import ru.alexandrorlov.avito_test.ui.theme.ShapesAvitoTest
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun AvitoTestButton(
    modifier: Modifier = Modifier,
    title: String,
    isErrorState: Boolean = true,
    onClick: () -> Unit,
) {

    Button(
        onClick = {
            if(isErrorState.not()) { onClick() }
        },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = dimensionResource(id = R.dimen.medium_padding),
                end = dimensionResource(id = R.dimen.medium_padding),
                bottom = dimensionResource(id = R.dimen.medium_padding),
            ),
        shape = MaterialTheme.ShapesAvitoTest.shapeButton,
        colors = ButtonColors(
            containerColor = if (isErrorState) LightGreyButton else BackgroundButton,
            contentColor = Color.Black,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
        ),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(id = R.dimen.small_padding),
                ),
            textAlign = TextAlign.Center,
            style = MaterialTheme.TypographyAvitoTest.textButton,
        )
    }
}

@Preview
@Composable
internal fun AvitoTestButtonEnableErrorStatePreview() {
    AvitoTestButton(
        title = stringResource(R.string.button_registration_title),
        isErrorState = true,
        onClick = {  },
    )
}

@Preview
@Composable
internal fun AvitoTestButtonDisableErrorStatePreview() {
    AvitoTestButton(
        title = stringResource(R.string.button_registration_title),
        isErrorState = false,
        onClick = {  },
    )
}