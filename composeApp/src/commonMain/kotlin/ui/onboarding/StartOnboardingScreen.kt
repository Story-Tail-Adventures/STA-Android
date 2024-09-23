package ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.painterResource
import story_tailadvenutures.composeapp.generated.resources.Res
import story_tailadvenutures.composeapp.generated.resources.sta_dark_logo
import story_tailadvenutures.composeapp.generated.resources.sta_logo
import ui.base.STAAdjustingLogo

class StartOnboardingScreen : Screen {
    @Composable
    override fun Content() {
        val isDark = isSystemInDarkTheme()
        val imageRes = if (isDark) Res.drawable.sta_dark_logo else Res.drawable.sta_logo

        val navigator = LocalNavigator.current

        Scaffold {
            Column(
                Modifier.padding(it).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(Modifier.weight(.15f))
                    STAAdjustingLogo(modifier = Modifier.weight(.7f), contentDescription = null)
                    IconButton(
                        onClick = {
                            navigator?.push(IntroOnboardingScreen())
                        },
                        modifier = Modifier.weight(.15f).size(80.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                        )
                    ){
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                    }
                }

            }

        }
    }
}