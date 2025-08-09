package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable fun HomeScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Intuitive Home", style = MaterialTheme.typography.headlineSmall)
        Text("Snapshot: armed, 3 doors locked, 8 cameras online, 22°C")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ElevatedButton(onClick = { }) { Text("Arm Away") }
            OutlinedButton(onClick = { }) { Text("Disarm") }
            OutlinedButton(onClick = { }) { Text("Guest Pass") }
        }
        Card { Column(Modifier.padding(12.dp)) {
            Text("Recent Events", style = MaterialTheme.typography.titleMedium)
            Text("• 10:32 — Front gate auto-opened by plate ABC-123")
            Text("• 10:02 — Package detected at Main Door")
            Text("• 09:18 — Lights turned off (scene)")
        } }
    }
}