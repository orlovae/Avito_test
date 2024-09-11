package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.data.models.Filter
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListCategory
import ru.alexandrorlov.avito_test.feature.product.ui.fakeListFilter

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

@Preview
@Composable
private fun HeaderScreenScreenStateCategoryLoadingScreenStateFilterLoading() {
    HeaderScreen(
        stateCategory = ScreenState.Loading,
        stateFilter = ScreenState.Loading,
        onSelectedCategory = {  },
        onSelectedFilter = {  },
    )
}

@Preview
@Composable
private fun HeaderScreenScreenStateCategoryContentScreenStateFilterLoading() {
    HeaderScreen(
        stateCategory = ScreenState.Content(
            content = fakeListCategory,
        ),
        stateFilter = ScreenState.Loading,
        onSelectedCategory = {  },
        onSelectedFilter = {  },
    )
}

@Preview
@Composable
private fun HeaderScreenScreenStateCategoryLoadingScreenStateFilterContent() {
    HeaderScreen(
        stateCategory = ScreenState.Loading,
        stateFilter = ScreenState.Content(
            content = fakeListFilter,
        ),
        onSelectedCategory = {  },
        onSelectedFilter = {  },
    )
}

@Preview
@Composable
private fun HeaderScreenScreenStateCategoryContentScreenStateFilterContent() {
    HeaderScreen(
        stateCategory = ScreenState.Content(
            content = fakeListCategory,
        ),
        stateFilter = ScreenState.Content(
            content = fakeListFilter,
        ),
        onSelectedCategory = {  },
        onSelectedFilter = {  },
    )
}
