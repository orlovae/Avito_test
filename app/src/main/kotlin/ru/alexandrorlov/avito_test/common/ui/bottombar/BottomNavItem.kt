package ru.alexandrorlov.avito_test.common.ui.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.alexandrorlov.avito_test.R

sealed class BottomNavItem(
    val screenRoot: String,
    @DrawableRes val icon: Int,
    @StringRes val titleId: Int
) {
    data object Search : BottomNavItem(
        screenRoot = SEARCH,
        icon = R.drawable.baseline_search_24,
        titleId = R.string.bottom_bar_search
    )

    data object Favorite : BottomNavItem(
        screenRoot = FAVORITE,
        icon = R.drawable.baseline_favorite_24,
        titleId = R.string.bottom_bar_favorite
    )

    data object Announcement : BottomNavItem(
        screenRoot = ANNOUNCEMENT,
        icon = R.drawable.baseline_library_announcement_24,
        titleId = R.string.bottom_bar_announcement
    )

    data object Message : BottomNavItem(
        screenRoot = MESSAGE,
        icon = R.drawable.baseline_message_24,
        titleId = R.string.bottom_bar_message
    )

    data object Profile : BottomNavItem(
        screenRoot = PROFILE,
        icon = R.drawable.baseline_profile_24,
        titleId = R.string.bottom_bar_profile
    )

    companion object {
        const val SEARCH = "search"
        const val FAVORITE = "favorite"
        const val ANNOUNCEMENT = "announcement"
        const val MESSAGE = "message"
        const val PROFILE = "profile"
    }
}