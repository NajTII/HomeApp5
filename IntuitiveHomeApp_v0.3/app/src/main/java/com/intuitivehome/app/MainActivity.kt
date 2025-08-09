package com.intuitivehome.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.intuitivehome.app.ui.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val items = listOf(
                    NavItem("home","Home", Icons.Default.Home),
                    NavItem("rooms","Rooms", Icons.Default.Dashboard),
                    NavItem("routines","Routines", Icons.Default.AutoMode),
                    NavItem("events","Events", Icons.Default.Notifications),
                    NavItem("access","Access", Icons.Default.VpnKey),
                    NavItem("camera","Cameras", Icons.Default.Videocam),
                    NavItem("talk","Talk", Icons.Default.Mic),
                    NavItem("settings","Settings", Icons.Default.Settings)
                )
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                            items.forEach { item ->
                                NavigationBarItem(
                                    selected = currentRoute == item.route,
                                    onClick = {
                                        if (currentRoute != item.route) {
                                            navController.navigate(item.route) {
                                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },
                                    icon = { Icon(item.icon, contentDescription = item.title) },
                                    label = { Text(item.title) }
                                )
                            }
                        }
                    }
                ) { inner ->
                    NavHost(navController, startDestination = "home", Modifier.padding(inner)) {
                        composable("home") { HomeScreen() }
                        composable("rooms") { RoomsDevicesScreen() }
                        composable("routines") { RoutinesScreen() }
                        composable("events") { EventsAlertsScreen() }
                        composable("access") { AccessPassesScreen() }
                        composable("camera") { CameraWallScreen() }
                        composable("talk") { TalkIntercomScreen() }
                        composable("settings") { SettingsScreen() }
                    }
                }
            }
        }
    }
}

data class NavItem(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)