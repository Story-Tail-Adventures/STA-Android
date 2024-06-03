package theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun StoryTailMaterialTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = StoryTailColors,
        typography = StoryTailTypography,
    ){
        content()
    }
}
