package ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.avito_test.R
import ru.alexandrorlov.avito_test.common.ui.SpacerMediumPadding
import ru.alexandrorlov.avito_test.common.ui.SpacerSmallPadding
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.ProductDetailUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.models.SpecificationUI
import ru.alexandrorlov.avito_test.feature.product_detail.ui.screen.data.getFakeProductDetailUI
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
internal fun SpecificationsComponent(
    product: ProductDetailUI,
) {
    Column {
        SpacerMediumPadding()

        if (product.specifications.isNotEmpty() || product.brand.isNotBlank()) {
            Text(
                text = stringResource(id = R.string.specification_product_detail),
                modifier = Modifier
                    .wrapContentSize(),
                style = MaterialTheme.TypographyAvitoTest.textNameSpecificationProductDetail
            )

            SpacerSmallPadding()

            if (product.brand.isNotBlank()) {
                RowSpecification(
                    specification = SpecificationUI(
                        key = stringResource(id = R.string.brand_product_detail),
                        value = product.brand,
                    ),
                )
            }

            if (product.specifications.isNotEmpty()) {
                LazyColumn {
                    items(product.specifications) { specification: SpecificationUI ->
                        RowSpecification(
                            specification = specification,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
internal fun SpecificationsComponentPreview() {
    SpecificationsComponent(
        product = getFakeProductDetailUI(),
    )
}
