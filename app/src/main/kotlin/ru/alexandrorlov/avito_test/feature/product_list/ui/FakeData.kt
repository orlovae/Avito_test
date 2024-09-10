package ru.alexandrorlov.avito_test.feature.product_list.ui

import androidx.annotation.StringRes
import ru.alexandrorlov.avito_test.R

internal data class Category(
    val title: String,
    val urlPhoto: String,
)

internal val fakeListCategory: List<Category> = listOf(
    Category(
        title = "chair",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=a98955ccaf6b5f50486d070f954b0944be1e2459ae12e3b3-12406511-images-thumbs&n=13",
    ),
    Category(
        title = "lamp",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=b9727c955aa062a2fd7b519659107f6db821b361-9222921-images-thumbs&n=13",
    ),
    Category(
        title = "clothing",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=f239fd141d2fa1a8ebd4e6d845d7136115ff9198f84a1213-12666658-images-thumbs&n=13",
    ),
    Category(
        title = "shorts",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=2df2d2cec8bc169d3c49327efc13f838fad7c54a-8497448-images-thumbs&n=13",
    ),
    Category(
        title = "footwear",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=85845f5402c628f1782a72254753d45e8aba58ea-4591921-images-thumbs&n=13",
    ),
)

internal sealed class Filter(
    @StringRes
    val titleId: Int,
) {
    data object PriceUp : Filter(titleId = R.string.price_up_filter)
    data object PriceDown : Filter(titleId = R.string.price_down_filter)
}

internal val fakeFilter: List<Filter> = listOf(
    Filter.PriceUp,
    Filter.PriceDown,
)