package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class EventItem(val time: String, val text: String)
@Composable fun EventsAlertsScreen() {
    val events = remember {
        listOf(
            EventItem("10:32", "Front gate auto-open by plate ABC-123"),
            EventItem("10:02", "Package detected at Main Door"),
            EventItem("09:18", "Lights turned off (scene)")
        )
    }
    LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(events) { e -> Card { Column(Modifier.padding(12.dp)) { Text(e.time); Text(e.text) } } }
    }
}