package ru.alexandrorlov.avito_test.feature.product.ui

import ru.alexandrorlov.avito_test.feature.product.data.models.Category
import ru.alexandrorlov.avito_test.feature.product.ui.models.Filter

internal val fakeFilter: List<Filter> = listOf(
    Filter.PriceUp,
    Filter.PriceDown,
)

val fakeListCategory: List<Category> = listOf(
    Category(
        id = 0,
        title = "chair",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=a98955ccaf6b5f50486d070f954b0944be1e2459ae12e3b3-12406511-images-thumbs&n=13",
        isSelected = false,
    ),
    Category(
        id = 1,
        title = "lamp",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=b9727c955aa062a2fd7b519659107f6db821b361-9222921-images-thumbs&n=13",
        isSelected = false,
    ),
    Category(
        id = 2,
        title = "clothing",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=f239fd141d2fa1a8ebd4e6d845d7136115ff9198f84a1213-12666658-images-thumbs&n=13",
        isSelected = false,
    ),
    Category(
        id = 3,
        title = "shorts",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=2df2d2cec8bc169d3c49327efc13f838fad7c54a-8497448-images-thumbs&n=13",
        isSelected = false,
    ),
    Category(
        id = 4,
        title = "footwear",
        urlPhoto = "https://avatars.mds.yandex.net/i?id=85845f5402c628f1782a72254753d45e8aba58ea-4591921-images-thumbs&n=13",
        isSelected = false,
    ),
)