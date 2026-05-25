package com.premium.dialer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import coil.compose.AsyncImage

private val MatteCharcoal = Color(0xFF141414)
private val OffWhite = Color(0xFFF4F1EA)
private val MutedGold = Color(0xFFC8A56B)

@Composable
fun BirthdayPremiumScreen() {
    val timeline = listOf(
        Triple("1996", "Born & loved", Icons.Outlined.Cake),
        Triple("2014", "First big dream", Icons.Outlined.AutoAwesome),
        Triple("2019", "A new chapter", Icons.Outlined.FavoriteBorder),
        Triple("2026", "Thirty in style", Icons.Outlined.StarBorder)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(MatteCharcoal, Color(0xFF0C0C0D), MatteCharcoal)
                )
            )
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                listOf("HOME", "OUR MEMORIES", "MESSAGES", "GIFT").forEach { item ->
                    Text(
                        text = item,
                        color = OffWhite.copy(alpha = 0.8f),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 14.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth().height(330.dp)) {
                Text(
                    text = "MAY AT\nTHIRTY",
                    color = OffWhite,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 106.sp,
                    fontSize = 104.sp,
                    letterSpacing = (-2).sp,
                    modifier = Modifier.align(Alignment.TopStart)
                )

                AsyncImage(
                    model = "https://images.unsplash.com/photo-1487412720507-e7ab37603c6f?auto=format&fit=crop&w=1200&q=80&sat=-100",
                    contentDescription = "Portrait",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(180.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topStart = 120.dp, bottomStart = 120.dp))
                )

                Box(
                    Modifier
                        .fillMaxHeight()
                        .width(180.dp)
                        .align(Alignment.CenterEnd)
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color.Transparent, Color.Black.copy(alpha = 0.45f))
                            )
                        )
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = "A Journey of Love & Celebration",
                color = OffWhite.copy(alpha = 0.88f),
                style = MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily.Serif
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = OffWhite
                ),
                modifier = Modifier
                    .height(58.dp)
                    .border(1.5.dp, MutedGold, RoundedCornerShape(999.dp))
                    .clip(RoundedCornerShape(999.dp)),
                contentPadding = PaddingValues(horizontal = 28.dp)
            ) {
                Text(
                    "UNLOCK THE STORY",
                    color = OffWhite,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(Modifier.height(34.dp))
            Text(
                text = "LIFE TIMELINE",
                color = MutedGold,
                fontSize = 12.sp,
                letterSpacing = 1.2.sp
            )
            Spacer(Modifier.height(12.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(timeline) { (year, title, icon) ->
                    TimelineCard(year = year, title = title, icon = icon)
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                text = "Brutalist elegance with soft particle glow.",
                color = OffWhite.copy(alpha = 0.45f),
                fontSize = 11.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun TimelineCard(year: String, title: String, icon: ImageVector) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0x1AF4F1EA))
            .border(1.dp, Color(0x26C8A56B), RoundedCornerShape(22.dp))
            .padding(14.dp)
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(Color(0x30C8A56B)),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Icon(icon, contentDescription = null, tint = MutedGold)
        }
        Spacer(Modifier.height(12.dp))
        Text(year, color = OffWhite, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(6.dp))
        Text(title, color = OffWhite.copy(alpha = 0.75f), fontSize = 12.sp)
    }
}
