package com.github.aether.model

data class EventResponse(
    val events: List<EnvironmentalEvent>
)

data class EnvironmentalEvent(
    val id: Int,
    val title: String,
    val type: String,
    val typeEmoji: String,
    val region: String,
    val severity: String,
    val description: String,
    val date: String,
    val satellite: String,
    val affectedAreaKm2: Double,
    val status: String,
    val temperature: String,
    val humidity: String,
    val windSpeed: String
)
