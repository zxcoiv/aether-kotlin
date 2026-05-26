package com.github.aether.model

data class AlertResponse(
    val alerts: List<EnvironmentalAlert>
)

data class EnvironmentalAlert(
    val id: Int,
    val title: String,
    val message: String,
    val region: String,
    val severity: String,
    val timestamp: String,
    var isRead: Boolean = false
)
