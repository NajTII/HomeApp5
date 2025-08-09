package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class RoomDevice(val room: String, val name: String, val type: String, val state: String)
@Composable fun RoomsDevicesScreen() {
    val devices = remember {
        listOf(
            RoomDevice("Entry", "Main Door Lock", "Lock", "Locked"),
            RoomDevice("Entry", "Doorbell", "Camera", "Online"),
            RoomDevice("Living", "Ceiling Lights", "Light", "On"),
            RoomDevice("Living", "Thermostat", "HVAC", "22°C"),
            RoomDevice("Driveway", "PTZ Cam", "Camera", "Online")
        )
    }
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(devices) { d ->
            Card { Column(Modifier.padding(12.dp)) {
                Text("${d.room} — ${d.name}", style = MaterialTheme.typography.titleMedium)
                Text("${d.type}: ${d.state}")
                Row(Modifier.padding(top = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = { }) { Text("Control") }
                    OutlinedButton(onClick = { }) { Text("Settings") }
                }
            } }
        }
    }
}