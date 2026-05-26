package com.github.aether.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aether.model.EnvironmentalAlert
import com.github.aether.service.AetherService
import com.github.aether.ui.theme.AetherTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertsScreen(
    onNavigateBack: () -> Unit
) {
    var alerts by remember { mutableStateOf(AetherService.getAlerts().alerts) }
    var showOnlyUnread by remember { mutableStateOf(false) }

    val displayed = if (showOnlyUnread) alerts.filter { !it.isRead } else alerts
    val unreadCount = alerts.count { !it.isRead }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Central de Alertas", fontWeight = FontWeight.Bold)
                        Text(
                            if (unreadCount > 0) "$unreadCount não lido(s)" else "Todos lidos",
                            fontSize = 11.sp,
                            color = if (unreadCount > 0)
                                Color(0xFFD32F2F)
                            else
                                Color(0xFF388E3C)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {
                    if (unreadCount > 0) {
                        TextButton(
                            onClick = {
                                alerts = alerts.map { it.copy(isRead = true) }
                            }
                        ) {
                            Text("Ler todos")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Toggle unread
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${displayed.size} alerta(s)",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Apenas não lidos", fontSize = 12.sp)
                    Spacer(Modifier.width(8.dp))
                    Switch(
                        checked = showOnlyUnread,
                        onCheckedChange = { showOnlyUnread = it }
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (displayed.isEmpty()) {
                    item {
                        Text(
                            text = "Nenhum alerta encontrado.",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                } else {
                    items(displayed, key = { it.id }) { alert ->
                        AlertCard(
                            alert = alert,
                            onMarkRead = {
                                alerts = alerts.map {
                                    if (it.id == alert.id) it.copy(isRead = true) else it
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AlertCard(
    alert: EnvironmentalAlert,
    onMarkRead: () -> Unit
) {
    val severityColor = when (alert.severity) {
        "CRÍTICA" -> Color(0xFFD32F2F)
        "ALTA"    -> Color(0xFFE64A19)
        "MÉDIA"   -> Color(0xFFF9A825)
        else      -> Color(0xFF388E3C)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (!alert.isRead)
                MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.08f)
            else
                MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (!alert.isRead) {
                    Icon(
                        imageVector = Icons.Default.Circle,
                        contentDescription = null,
                        tint = severityColor,
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                }
                Text(
                    text = alert.title,
                    fontSize = 14.sp,
                    fontWeight = if (!alert.isRead) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )
                SeverityChip(severity = alert.severity)
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = alert.message,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = alert.region,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                    Text(
                        text = alert.timestamp,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
                if (!alert.isRead) {
                    TextButton(onClick = onMarkRead) {
                        Text("Marcar como lido", fontSize = 11.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertsScreenPreview() {
    AetherTheme {
        AlertsScreen(onNavigateBack = {})
    }
}
