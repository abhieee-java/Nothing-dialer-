package com.premium.dialer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.premium.dialer.ui.screens.BirthdayPremiumScreen
import com.premium.dialer.ui.theme.NothingDialerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { NothingDialerTheme { DialerApp() } }
    }
}

@Composable
fun DialerApp() {
    BirthdayPremiumScreen()
}
