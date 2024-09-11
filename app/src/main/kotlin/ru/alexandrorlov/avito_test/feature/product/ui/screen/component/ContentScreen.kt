package ru.alexandrorlov.avito_test.feature.product.ui.screen.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.avito_test.common.model.ScreenState
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product.ui.models.ProductUI

@Composable
internal fun ContentScreen(
    modifier: Modifier,
    state: ScreenState<List<ProductUI>>,
    navigateToProductDetailScreen: (String) -> Unit,
) {
    when (state) {
        Loading -> { LoadingScreen(modifier = modifier) }

        is Content -> {
            Column(modifier = modifier) {
                SpacerSmallPadding()

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .weight(10f)
                        .fillMaxSize(),
                ) {
                    items(state.content) { product: ProductUI ->
                        CardProduct(
                            product = product,
                            onClickProduct = {
                                navigateToProductDetailScreen(product.id)
                            }
                        )
                    }
                }
            }
        }

        is Error -> {
            Log.d("OAE", "Error ${state.message}")
        }
    }
}