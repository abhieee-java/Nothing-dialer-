package com.premium.dialer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.premium.dialer.ui.theme.SoftCard

@Composable
fun PillSearchBar(query: String, onQuery: (String) -> Unit, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = query,
        onValueChange = onQuery,
        leadingIcon = { Icon(Icons.Outlined.Search, null, tint = Color.Gray) },
        placeholder = { Text("Search contacts...", color = Color.Gray) },
        singleLine = true,
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(40.dp)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = SoftCard.copy(alpha = 0.85f),
            unfocusedContainerColor = SoftCard.copy(alpha = 0.85f),
            focusedBorderColor = Color.White.copy(alpha = 0.2f),
            unfocusedBorderColor = Color.White.copy(alpha = 0.08f),
            focusedTextColor = Color.White, unfocusedTextColor = Color.White
        )
    )
}

@Composable
fun GlassCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier.clip(RoundedCornerShape(24.dp)).background(SoftCard.copy(alpha = 0.85f)).border(1.dp, Color.White.copy(0.07f), RoundedCornerShape(24.dp)).padding(16.dp), content = content)
}

@Composable
fun BottomPillNav(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    Row(modifier.fillMaxWidth().height(72.dp).clip(RoundedCornerShape(40.dp)).background(SoftCard.copy(0.95f)).padding(horizontal = 28.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround, content = content)
}
