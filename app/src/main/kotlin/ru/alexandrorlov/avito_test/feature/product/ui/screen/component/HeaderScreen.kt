package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter

@Composable
internal fun HeaderScreen(
    modifier: Modifier = Modifier,
    stateCategory: ScreenState<List<Category>>,
    stateFilter: ScreenState<List<Filter>>,
    onSelectedCategory: (Category) -> Unit,
    onSelectedFilter: (Filter) -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        CategoryComponent(
            modifier = Modifier
                .weight(4F),
            stateCategory = stateCategory,
            onSelectedCategory = onSelectedCategory,
        )

        SpacerSmallPadding()

        FilterComponent(
            modifier = Modifier
                .weight(1F),
            stateFilter = stateFilter,
            onSelectedFilter = onSelectedFilter,
        )
    }
}
