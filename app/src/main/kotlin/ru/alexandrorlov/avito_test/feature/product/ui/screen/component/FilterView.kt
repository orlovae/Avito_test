package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.ui.theme.BackgroundTextField
import ru.alexandrorlov.avito_test.ui.theme.BackgroundTextFieldInvert
import ru.alexandrorlov.avito_test.ui.theme.CategoryText
import ru.alexandrorlov.avito_test.ui.theme.CategoryTextInvert
import ru.alexandrorlov.avito_test.ui.theme.RedBorder
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun FilterView(
    modifier: Modifier = Modifier,
    filter: Filter,
    onSelected: () -> Unit,
) {
    val isSelected: Boolean = filter.isSelected

    FilterChip(
        onClick = { onSelected() },
        label = {
            Text(
                text = stringResource(id = filter.idTitle).uppercase(),
                style = MaterialTheme.TypographyAvitoTest.textFilter,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        modifier = modifier,
        selected = isSelected,
        enabled = true,
        border = BorderStroke(
            width = dimensionResource(id = R.dimen.border_thickness_category),
            color = if (isSelected) RedBorder else Color.Unspecified,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = BackgroundTextField,
            selectedContainerColor = BackgroundTextFieldInvert,
            labelColor = CategoryText,
            selectedLabelColor = CategoryTextInvert,
        ),
    )

    Spacer(modifier = Modifier
        .size(dimensionResource(id = R.dimen.x_x_small_padding)),
    )
}

@Preview
@Composable
private fun FilterViewUnSelectedPreview() {
    FilterView(
        filter = Filter(
            idTitle = R.string.price_up_filter,
            query = "",
        )
        ,
        onSelected = { },
    )
}

@Preview
@Composable
private fun FilterViewSelectedPreview() {
    FilterView(
        filter = Filter(
            idTitle = R.string.price_up_filter,
            query = "",
            isSelected = true,
        )
        ,
        onSelected = { },
    )
}
