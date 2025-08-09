package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class AccessPass(val name: String, val method: String, val scope: String)
@Composable fun AccessPassesScreen() {
    val passes = remember {
        listOf(
            AccessPass("Family - Aisha", "Face + Geo", "All doors"),
            AccessPass("Gardener", "WhatsApp OTP", "Service gate, Wed 8–12"),
            AccessPass("Courier", "QR One-time", "Main door, today")
        )
    }
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ElevatedButton(onClick = { }) { Text("New Pass") }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(passes) { p ->
                Card { Column(Modifier.padding(12.dp)) {
                    Text(p.name, style = MaterialTheme.typography.titleMedium)
                    Text("${p.method} — ${p.scope}")
                    Row(Modifier.padding(top = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { }) { Text("Share") }
                        OutlinedButton(onClick = { }) { Text("Revoke") }
                    }
                } }
            }
        }
    }
}