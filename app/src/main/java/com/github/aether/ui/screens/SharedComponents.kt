package com.github.aether.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SeverityChip(severity: String) {
    val color = when (severity) {
        "CRÍTICA" -> Color(0xFFD32F2F)
        "ALTA"    -> Color(0xFFE64A19)
        "MÉDIA"   -> Color(0xFFF9A825)
        else      -> Color(0xFF388E3C)
    }
    Box(
        modifier = Modifier
            .background(color.copy(alpha = 0.15f), RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = severity,
            fontSize = 10.sp,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StatusChip(status: String) {
    val color = when (status) {
        "ATIVO"       -> Color(0xFFD32F2F)
        "MONITORANDO" -> Color(0xFFF9A825)
        "RESOLVIDO"   -> Color(0xFF388E3C)
        else          -> MaterialTheme.colorScheme.onSurface
    }
    Box(
        modifier = Modifier
            .background(color.copy(alpha = 0.10f), RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = "● $status",
            fontSize = 10.sp,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}
