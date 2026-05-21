package com.premium.dialer.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PureBlack = Color(0xFF000000)
val SoftCard = Color(0xFF121417)
val White = Color(0xFFF4F4F4)
val RedAccent = Color(0xFFE50914)

private val Scheme = darkColorScheme(
    background = PureBlack,
    surface = SoftCard,
    onBackground = White,
    onSurface = White,
    primary = RedAccent
)

@Composable
fun NothingDialerTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = Scheme, typography = Typography(), content = content)
}
