package ru.alexandrorlov.avito_test.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ru.alexandrorlov.avito_test.common.ui.bottombar.BottomNavItem
import ru.alexandrorlov.avito_test.ui.theme.TypographyAvitoTest

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.Search,
        BottomNavItem.Favorite,
        BottomNavItem.Announcement,
        BottomNavItem.Message,
        BottomNavItem.Profile,
    )
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items.forEach { item ->
                IconButton(
                    modifier = Modifier
                        .fillMaxHeight(),
                    onClick = { },
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.titleId),
                        )

                        Text(
                            text = stringResource(id = item.titleId),
                            softWrap = false,
                            style = MaterialTheme.TypographyAvitoTest.titleBottombar
                        )
                    }
                }
            }
        }
    }
}