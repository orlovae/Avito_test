package ru.alexandrorlov.avito_test.common.ui.textfield.password

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.avito_test.R

@Composable
internal fun DecorationBox(
    onPasswordHiddenChange: (Boolean) -> Unit,
    innerTextField: @Composable () -> Unit,
) {
    var passwordHidden by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = dimensionResource(R.dimen.medium_padding)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        innerTextField()
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(
            onClick = {
                passwordHidden = !passwordHidden
                onPasswordHiddenChange(passwordHidden)
            },
        ) {
            val painterIcon =
                if (passwordHidden) {
                    painterResource(R.drawable.visibility_on)
                } else {
                    painterResource(R.drawable.visibility_off)
                }

            val description =
                if (passwordHidden) {
                    stringResource(R.string.show_password_text_field)
                } else {
                    stringResource(R.string.hide_password_text_field)
                }

            Icon(
                painter = painterIcon,
                contentDescription = description,
            )
        }
    }
}
