package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class Routine(val name: String, val detail: String)
@Composable fun RoutinesScreen() {
    val routines = remember {
        listOf(
            Routine("Good Night", "Lock doors, arm perimeter, set 20°C, lights off"),
            Routine("Arriving Home", "Disarm, porch lights on, set 22°C"),
            Routine("Away Mode", "Arm all zones, presence simulation")
        )
    }
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ElevatedButton(onClick = { }) { Text("New Routine") }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(routines) { r ->
                Card { Column(Modifier.padding(12.dp)) {
                    Text(r.name, style = MaterialTheme.typography.titleMedium)
                    Text(r.detail)
                    Row(Modifier.padding(top = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { }) { Text("Run") }
                        OutlinedButton(onClick = { }) { Text("Edit") }
                    }
                } }
            }
        }
    }
}