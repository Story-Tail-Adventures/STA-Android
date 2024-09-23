package ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.CrossfadeTransition

private const val MAIN_SCREEN = "MainScreen"

class MainScreen : Screen {
    @Composable
    override fun Content() {
        Navigator(HomeScreen(), key = MAIN_SCREEN) { navigator ->
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        tonalElevation = 10.dp
                    ) {
                        IconButton(
                            modifier = Modifier.weight(.3f),
                            onClick = { navigator.replace(HomeScreen()) }
                        ) {
                            Icon(
                                Icons.Default.Home,
                                "Home"
                            )
                        }
                        IconButton(
                            modifier = Modifier.weight(.3f),
                            onClick = {}) { Icon(Icons.Default.MailOutline, "Notifications") }
                        IconButton(
                            modifier = Modifier.weight(.3f),
                            onClick = { navigator.replace(AccountScreen()) }) {
                            Icon(
                                Icons.Default.AccountCircle,
                                "Accounts"
                            )
                        }
                    }
                },
            ) {
                CrossfadeTransition(navigator = navigator, modifier = Modifier.padding(it))
            }
        }
    }
}