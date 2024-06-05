import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import story_tailadvenutures.composeapp.generated.resources.Res
import story_tailadvenutures.composeapp.generated.resources.sta_logo
import theme.StoryTailMaterialTheme

@Composable
@Preview
fun App() {
    StoryTailMaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                     TopAppBar(title = {Text("Story-Tail Adventures")})
                     },
            drawerContent = {
                Text("Drawer content")
            }
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.sta_logo), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }

    }
}