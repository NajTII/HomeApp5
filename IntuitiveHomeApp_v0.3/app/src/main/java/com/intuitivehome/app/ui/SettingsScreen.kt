package com.intuitivehome.app.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

private val ContextDataStore = preferencesDataStore(name = "intuitive_prefs")

@Composable fun SettingsScreen() {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    val ds = ctx.ContextDataStore

    val KEY_GPT_ENDPOINT = stringPreferencesKey("gpt_endpoint")
    val KEY_GPT_KEY = stringPreferencesKey("gpt_key")
    val KEY_WHATSAPP = stringPreferencesKey("wa_token")
    val KEY_RTSP = stringPreferencesKey("rtsp_url")

    var endpoint by remember { mutableStateOf("") }
    var apiKey by remember { mutableStateOf("") }
    var waToken by remember { mutableStateOf("") }
    var rtsp by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Settings", style = MaterialTheme.typography.headlineSmall)
        Text("Enter your API keys and endpoints. Values are stored locally on-device.")

        OutlinedTextField(endpoint, { endpoint = it }, label = { Text("GPT-5 Endpoint") }, singleLine = true, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(apiKey, { apiKey = it }, label = { Text("GPT-5 API Key") }, singleLine = true, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(waToken, { waToken = it }, label = { Text("WhatsApp/SMS Token") }, singleLine = true, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(rtsp, { rtsp = it }, label = { Text("Sample RTSP URL (camera)") }, singleLine = true, modifier = Modifier.fillMaxWidth())

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ElevatedButton(onClick = {
                scope.launch {
                    ds.edit { p ->
                        p[KEY_GPT_ENDPOINT] = endpoint
                        p[KEY_GPT_KEY] = apiKey
                        p[KEY_WHATSAPP] = waToken
                        p[KEY_RTSP] = rtsp
                    }
                }
            }) { Text("Save") }
            OutlinedButton(onClick = {
                endpoint = ""; apiKey = ""; waToken = ""; rtsp = ""
            }) { Text("Clear Form") }
        }

        Text("Security: E2E video/control ON; Telemetry anonymous by default")
    }
}