package ru.alexandrorlov.avito_test.feature.registration.ui.screen.component.textfield.name

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ru.alexandrorlov.avito_test.R

@Composable
internal fun DecorationBox(
    innerTextField: @Composable () -> Unit,
) {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.medium_padding)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        innerTextField()
    }
}
