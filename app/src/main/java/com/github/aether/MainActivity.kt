package com.github.aether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.aether.ui.screens.AlertsScreen
import com.github.aether.ui.screens.EventDetailScreen
import com.github.aether.ui.screens.EventsScreen
import com.github.aether.ui.screens.HomeScreen
import com.github.aether.ui.screens.SatellitesScreen
import com.github.aether.ui.screens.SplashScreen
import com.github.aether.ui.theme.AetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AetherTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable(route = "splash") {
                        SplashScreen(
                            onNavigateToHome = {
                                navController.navigate("home") {
                                    popUpTo("splash") { inclusive = true }
                                }
                            }
                        )
                    }

                    composable(route = "home") {
                        HomeScreen(
                            onNavigateToEvents = { navController.navigate("events") },
                            onNavigateToSatellites = { navController.navigate("satellites") },
                            onNavigateToAlerts = { navController.navigate("alerts") },
                            onNavigateToEventDetail = { eventId ->
                                navController.navigate("event_detail/$eventId")
                            }
                        )
                    }

                    composable(route = "events") {
                        EventsScreen(
                            onNavigateBack = { navController.popBackStack() },
                            onNavigateToDetail = { eventId ->
                                navController.navigate("event_detail/$eventId")
                            }
                        )
                    }

                    composable(
                        route = "event_detail/{eventId}",
                        arguments = listOf(navArgument("eventId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val eventId = backStackEntry.arguments?.getInt("eventId") ?: return@composable
                        EventDetailScreen(
                            eventId = eventId,
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }

                    composable(route = "satellites") {
                        SatellitesScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }

                    composable(route = "alerts") {
                        AlertsScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}