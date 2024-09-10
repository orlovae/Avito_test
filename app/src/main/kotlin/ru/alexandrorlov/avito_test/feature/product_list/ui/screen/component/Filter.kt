package ru.alexandrorlov.avito_test.feature.product_list.ui.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun Filter(
    modifier: Modifier = Modifier,
    title: String,
    onSelected: () -> Unit,
) {
    var selected by rememberSaveable { mutableStateOf(false) }

    FilterChip(
        onClick = {
            selected = selected.not()
            if (selected) {
                onSelected()
            }
        },
        label = {
            Text(
                text = title.uppercase(),
                style = MaterialTheme.TypographyAvitoTest.textFilter,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        modifier = modifier,
        selected = selected,
        enabled = true,
        border = BorderStroke(
            width = dimensionResource(id = R.dimen.border_thickness_category),
            color = Color.Black,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = Color.Black,
            labelColor = Color.Black,
            selectedLabelColor = Color.White,
        ),
    )

    Spacer(modifier = Modifier
        .size(dimensionResource(id = R.dimen.x_x_small_padding)),
    )
}

@Preview
@Composable
private fun FilterPreview() {
    Filter(
        title = "price \u2191",
        onSelected = { },
    )
}
