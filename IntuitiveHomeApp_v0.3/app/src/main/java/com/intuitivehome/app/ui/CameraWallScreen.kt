package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun CameraWallScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Camera Wall", style = MaterialTheme.typography.headlineSmall)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(2) { Card(Modifier.weight(1f)) { Box(Modifier.height(120.dp)) { Text("Cam ${it+1}", Modifier.padding(8.dp)) } } }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(2) { Card(Modifier.weight(1f)) { Box(Modifier.height(120.dp)) { Text("Cam ${it+3}", Modifier.padding(8.dp)) } } }
        }
    }
}