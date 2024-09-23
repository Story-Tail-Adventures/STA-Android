package ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import story_tailadvenutures.composeapp.generated.resources.Res
import story_tailadvenutures.composeapp.generated.resources.sta_dark_logo
import story_tailadvenutures.composeapp.generated.resources.sta_logo

@Composable
fun STAAdjustingLogo(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val isDark = isSystemInDarkTheme()
    val imageRes = if (isDark) Res.drawable.sta_dark_logo else Res.drawable.sta_logo
    Image(
        painter = painterResource(imageRes),
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}