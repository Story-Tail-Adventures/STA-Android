import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.onboarding.StartOnboardingScreen
import ui.theme.AppTheme

@OptIn(ExperimentalVoyagerApi::class)
@Composable
@Preview
fun App() {
    AppTheme {
        Navigator(
            StartOnboardingScreen(),
        ) { navigator ->
            SlideTransition(
                navigator = navigator,
                disposeScreenAfterTransitionEnd = true
            )
        }
    }
}