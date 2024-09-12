package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.product_detail.ui.viewmodels.ProductDetailViewModel

@Composable
internal fun ProductDetailScreen(
    idProduct: String,
    navController: NavController,
    viewModel: ProductDetailViewModel = daggerViewModel(),
) {
    viewModel.idProductDetail.tryEmit(idProduct)

    val state = viewModel.state.collectAsState()

    when (val data = state.value) {
        Loading -> {
            Log.d("OAE", "ScreenState = Loading")
        }

        is Content -> {

            Log.d("OAE", "ScreenState = Content")

            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Text(
                    text = "Product ID = $idProduct"
                )

                Text(
                    text = "Product = ${data.content}"
                )
            }
        }

        is Error -> {
            Log.d("OAE", "ScreenState = Error")
        }
    }
}

@Preview
@Composable
internal fun PreviewProductDetailScreen() {

}