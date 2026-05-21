package com.premium.dialer.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.premium.dialer.model.CallDirection
import com.premium.dialer.model.Contact
import com.premium.dialer.ui.components.*
import com.premium.dialer.ui.theme.RedAccent

@Composable fun Title(text:String)=Text(text, fontFamily = FontFamily.Serif, fontSize = 52.sp, color = Color.White)

@Composable
fun RecentsScreen(query:String,onQuery:(String)->Unit, data:List<com.premium.dialer.model.RecentCall>, onContact:()->Unit){
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Title("Recents")
        Spacer(Modifier.height(12.dp)); PillSearchBar(query,onQuery)
        Spacer(Modifier.height(18.dp)); Text("RECENT", color=Color.White.copy(.7f), fontWeight=FontWeight.Bold)
        LazyColumn(Modifier.weight(1f).animateContentSize()) { items(data){r-> Row(Modifier.fillMaxWidth().padding(vertical=10.dp).clickable{onContact()}, verticalAlignment=Alignment.CenterVertically){ AsyncImage(r.contact.image,null,Modifier.size(52.dp).clip(CircleShape)); Spacer(Modifier.width(12.dp)); Column(Modifier.weight(1f)){ Text(r.contact.name, color=if(r.contact.redAccent) RedAccent else Color.White, fontWeight=FontWeight.SemiBold); Text("${if(r.direction==CallDirection.MISSED) "↙" else "↗"} ${r.carrierTime}", color=Color.Gray, fontSize=13.sp)}; Icon(Icons.Outlined.Call,null,tint=Color.White.copy(.8f)) }} }
    }
}

@Composable fun FavoritesScreen(query:String,onQuery:(String)->Unit, data:List<Contact>, onContact:()->Unit){
    Column(Modifier.fillMaxSize().padding(20.dp)){ Title("Favorites"); Spacer(Modifier.height(12.dp)); PillSearchBar(query,onQuery); Spacer(Modifier.height(14.dp)); LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), verticalArrangement = Arrangement.spacedBy(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)){ items(data.filter{it.favorite}){ c-> GlassCard(Modifier.clickable{onContact()}){ Text(c.name,color=Color.White); Spacer(Modifier.height(8.dp)); AsyncImage(c.image,null,Modifier.fillMaxWidth().height(120.dp).clip(RoundedCornerShape(18.dp))) } } } }
}

@Composable fun ContactDetailScreen(contact: Contact, history: List<com.premium.dialer.model.CallHistoryItem>) {
    LazyColumn(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item { Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){ AsyncImage(contact.image,null,Modifier.size(96.dp).clip(CircleShape)); Text(contact.name, fontFamily = FontFamily.Serif, fontSize = 44.sp,color=Color.White); Text(contact.subtitle,color=Color.Gray) } }
        item { GlassCard { Text(contact.phone,color=Color.White,fontSize=30.sp); Text("Mobile",color=Color.Gray); Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){ Icon(Icons.Outlined.Videocam,null); Spacer(Modifier.width(18.dp)); Icon(Icons.Outlined.Call,null); Spacer(Modifier.width(18.dp)); Icon(Icons.Outlined.Message,null) } } }
        item { Text("HISTORY",color=Color.White.copy(.7f),fontWeight = FontWeight.Bold) }
        items(history){ h-> GlassCard{ Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){ Text("${if(h.direction==CallDirection.MISSED) "↘" else "↖"} ${h.time}", color=if(h.direction==CallDirection.MISSED) RedAccent else Color.White); Text(h.duration,color=Color.Gray)}; Text(h.number,color=Color.Gray)} }
        item { Text("MORE INFO",color=Color.White.copy(.7f),fontWeight = FontWeight.Bold) }
        item { GlassCard{ Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){ Column{Text("Whatsapp",color=Color.White); Text(contact.phone,color=Color.Gray)}; Row{Icon(Icons.Outlined.Call,null); Spacer(Modifier.width(16.dp)); Icon(Icons.Outlined.Message,null)} } } }
    }
}

@Composable fun ActiveCallScreen(contact: Contact){
    Box(Modifier.fillMaxSize().background(Color.Black)){
        AsyncImage(contact.image,null,Modifier.fillMaxWidth().height(420.dp).clip(RoundedCornerShape(bottomStart = 32.dp,bottomEnd = 32.dp)))
        Box(Modifier.fillMaxWidth().height(420.dp).background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(.85f)))))
        Column(Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){ Spacer(Modifier.height(280.dp)); Text(contact.name,fontFamily=FontFamily.Serif,fontSize = 54.sp,color=Color.White); Text("30:11",color=Color.White,modifier=Modifier.background(RedAccent, RoundedCornerShape(999.dp)).padding(horizontal = 14.dp,vertical=4.dp)); Spacer(Modifier.height(30.dp));
            val labels = listOf("Mute" to Icons.Outlined.MicOff,"Keypad" to Icons.Outlined.Dialpad,"Speaker" to Icons.Outlined.VolumeUp,"Add Call" to Icons.Outlined.AddCall,"Hold" to Icons.Outlined.Pause,"Add Number" to Icons.Outlined.ContactPage)
            labels.chunked(3).forEach{row-> Row(horizontalArrangement = Arrangement.spacedBy(24.dp)){ row.forEach{(l,i)-> Column(horizontalAlignment = Alignment.CenterHorizontally){ Box(Modifier.size(74.dp).clip(CircleShape).background(Color(0xFF1A1D22)),contentAlignment = Alignment.Center){ Icon(i,null,tint=if(l=="Speaker") Color.Black else Color.White)}; Text(l,color=Color.Gray) } } }; Spacer(Modifier.height(16.dp))}
            Spacer(Modifier.weight(1f)); FloatingActionButton(onClick = {}, containerColor = RedAccent, modifier=Modifier.size(92.dp)){ Icon(Icons.Outlined.CallEnd,null,tint=Color.White, modifier = Modifier.size(34.dp)) }
        }
    }
}
