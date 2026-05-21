package com.premium.dialer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.premium.dialer.ui.components.BottomPillNav
import com.premium.dialer.ui.screens.*
import com.premium.dialer.ui.theme.NothingDialerTheme
import com.premium.dialer.ui.theme.RedAccent
import com.premium.dialer.viewmodel.DialerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { NothingDialerTheme { DialerApp() } }
    }
}

@Composable
fun DialerApp(vm: DialerViewModel = viewModel()) {
    val nav = rememberNavController()
    val state by vm.uiState.collectAsState()
    Scaffold(containerColor = Color.Black, floatingActionButton = {
        FloatingActionButton(onClick = { nav.navigate("call") }, containerColor = RedAccent) { Icon(Icons.Outlined.Dialpad, null) }
    }, floatingActionButtonPosition = FabPosition.Center, bottomBar = {
        BottomPillNav(Modifier.padding(horizontal = 22.dp, vertical = 10.dp)) {
            IconButton(onClick = { nav.navigate("favorites") }) { Icon(Icons.Outlined.FavoriteBorder, null, tint = Color.White) }
            IconButton(onClick = { nav.navigate("recents") }) { Icon(Icons.Outlined.History, null, tint = RedAccent) }
            IconButton(onClick = { nav.navigate("detail") }) { Icon(Icons.Outlined.PersonOutline, null, tint = Color.White) }
        }
    }) { p ->
        NavHost(nav, startDestination = "recents", Modifier.padding(p).background(Color.Black)) {
            composable("recents") { RecentsScreen(state.query, vm::onQueryChange, vm.recents) { nav.navigate("detail") } }
            composable("favorites") { FavoritesScreen(state.query, vm::onQueryChange, vm.contacts) { nav.navigate("detail") } }
            composable("detail") { ContactDetailScreen(vm.contacts.last(), vm.history) }
            composable("call") { ActiveCallScreen(vm.contacts[3]) }
        }
    }
}
