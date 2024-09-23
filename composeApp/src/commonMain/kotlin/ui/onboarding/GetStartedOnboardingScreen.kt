package ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.stringResource
import story_tailadvenutures.composeapp.generated.resources.Res
import story_tailadvenutures.composeapp.generated.resources.get_started_onboarding_button_text
import story_tailadvenutures.composeapp.generated.resources.get_started_onboarding_title
import ui.MainScreen
import ui.base.STAAdjustingLogo

class GetStartedOnboardingScreen : Screen {
    @Composable
    override fun Content() {
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
                    IconButton(
                        onClick = {
                            navigator?.pop()
                        },
                        modifier = Modifier.weight(.15f).size(80.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                        )
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                    Column(
                        modifier = Modifier.weight(.7f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            stringResource(Res.string.get_started_onboarding_title),
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        STAAdjustingLogo(contentDescription = null)
                    }
                    TextButton(
                        onClick = {
                            navigator?.replaceAll(MainScreen())
                        },
                        modifier = Modifier.weight(.15f).size(80.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                        )
                    ) {
                        Text(stringResource(Res.string.get_started_onboarding_button_text))
                    }
                }

            }

        }
    }
}