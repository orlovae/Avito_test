package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.model.ScreenState.Content
import ru.alexandrorlov.avito_test.common.model.ScreenState.Error
import ru.alexandrorlov.avito_test.common.model.ScreenState.Loading
import ru.alexandrorlov.avito_test.common.model.SideEffect
import ru.alexandrorlov.avito_test.common.ui.LoadingScreen
import ru.alexandrorlov.avito_test.common.ui.SnackbarAvitoTest
import ru.alexandrorlov.avito_test.di.daggerViewModel
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component.ContentScreen
import ru.alexandrorlov.avito_test.feature.product_detail.ui.viewmodels.ProductDetailViewModel

@Composable
internal fun ProductDetailScreen(
    idProduct: String,
    navController: NavController,
    viewModel: ProductDetailViewModel = daggerViewModel(),
) {
    viewModel.idProductDetail.tryEmit(idProduct)

    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    val context: Context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {

                is SideEffect.SnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = sideEffect.message.asString(context = context),
                    )
                }
            }
        }
    }

    val state = viewModel.state.collectAsState()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                SnackbarAvitoTest(
                    snackBarText = data.visuals.message,
                )
            }
        },
    ) { innerPadding: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
        ) {
        when (val data = state.value) {
            Loading -> { LoadingScreen() }

            is Content -> {

                ContentScreen(
                    product = data.content,
                    onClickButtonBuy = { viewModel.onClickButton.tryEmit("") },
                )
            }

            is Error -> {
                Log.d("OAE", "ScreenState = Error")
            }
        }
        }
    }
}

@Preview
@Composable
internal fun PreviewProductDetailScreen() {

}
