package com.github.aether.model

data class SatelliteResponse(
    val satellites: List<Satellite>
)

data class Satellite(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val typeEmoji: String,
    val altitude: Int,
    val orbitType: String,
    val status: String,
    val launchDate: String,
    val agency: String,
    val coverageArea: String,
    val instruments: List<String>,
    val lastPassTime: String,
    val nextPassTime: String
)
