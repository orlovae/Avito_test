package ru.alexandrorlov.avito_test.common.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ru.alexandrorlov.avito_test.R

@Composable
fun SpacerMediumPadding() {
    Spacer(modifier = Modifier.size(dimensionResource(R.dimen.medium_padding)))
}

@Composable
fun SpacerSmallPadding() {
    Spacer(modifier = Modifier.size(dimensionResource(R.dimen.small_padding)))
}
