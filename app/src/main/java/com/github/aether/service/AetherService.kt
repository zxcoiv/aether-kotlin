package com.github.aether.service

import com.github.aether.model.*

object AetherService {

    fun getEvents(): EventResponse {
        return EventResponse(
            events = listOf(
                EnvironmentalEvent(
                    id = 1,
                    title = "Incêndio no Pantanal",
                    type = "Incêndio Florestal",
                    typeEmoji = "🔥",
                    region = "Mato Grosso do Sul, BR",
                    severity = "CRÍTICA",
                    description = "Grande foco de incêndio detectado na região do Pantanal. Dados do satélite CBERS-4A indicam propagação rápida em direção às reservas naturais. Equipes da Defesa Civil mobilizadas para contenção.",
                    date = "26/05/2025 – 14:32",
                    satellite = "CBERS-4A",
                    affectedAreaKm2 = 1240.0,
                    status = "ATIVO",
                    temperature = "38.5°C",
                    humidity = "18%",
                    windSpeed = "42 km/h"
                ),
                EnvironmentalEvent(
                    id = 2,
                    title = "Enchente – Vale do Itajaí",
                    type = "Enchente",
                    typeEmoji = "🌊",
                    region = "Santa Catarina, BR",
                    severity = "ALTA",
                    description = "Precipitação acima da média nos últimos 3 dias causa alagamentos no Vale do Itajaí. Nível do rio subiu 4,2 metros acima do normal. Alerta máximo para municípios ribeirinhos.",
                    date = "25/05/2025 – 09:15",
                    satellite = "Sentinel-2",
                    affectedAreaKm2 = 320.0,
                    status = "ATIVO",
                    temperature = "22.0°C",
                    humidity = "95%",
                    windSpeed = "18 km/h"
                ),
                EnvironmentalEvent(
                    id = 3,
                    title = "Seca Severa – Nordeste",
                    type = "Seca",
                    typeEmoji = "☀️",
                    region = "Sertão CE/PB/RN, BR",
                    severity = "ALTA",
                    description = "Imagens espectrais revelam redução de 67% na cobertura vegetal. Índice NDVI em mínimos históricos. Emergência hídrica declarada em 43 municípios da região semiárida.",
                    date = "24/05/2025 – 11:00",
                    satellite = "Landsat-9",
                    affectedAreaKm2 = 45000.0,
                    status = "MONITORANDO",
                    temperature = "41.0°C",
                    humidity = "12%",
                    windSpeed = "25 km/h"
                ),
                EnvironmentalEvent(
                    id = 4,
                    title = "Desmatamento – Pará",
                    type = "Desmatamento",
                    typeEmoji = "🌳",
                    region = "Pará, BR",
                    severity = "ALTA",
                    description = "Análise de radar SAR identificou novo polígono de desmatamento com 890 km² em área de proteção ambiental. IBAMA e Polícia Federal notificados. Operação de fiscalização em andamento.",
                    date = "23/05/2025 – 08:45",
                    satellite = "ALOS-2",
                    affectedAreaKm2 = 890.0,
                    status = "ATIVO",
                    temperature = "34.0°C",
                    humidity = "72%",
                    windSpeed = "12 km/h"
                ),
                EnvironmentalEvent(
                    id = 5,
                    title = "Tempestade Extratropical",
                    type = "Tempestade",
                    typeEmoji = "⛈️",
                    region = "Rio Grande do Sul, BR",
                    severity = "MÉDIA",
                    description = "Sistema de baixa pressão identificado pelo GOES-16 com ventos de até 95 km/h. Previsão de passagem pelas áreas metropolitanas nas próximas 12 horas.",
                    date = "22/05/2025 – 17:20",
                    satellite = "GOES-16",
                    affectedAreaKm2 = 12000.0,
                    status = "MONITORANDO",
                    temperature = "16.0°C",
                    humidity = "87%",
                    windSpeed = "95 km/h"
                ),
                EnvironmentalEvent(
                    id = 6,
                    title = "Deslizamento – Serra Gaúcha",
                    type = "Deslizamento",
                    typeEmoji = "⛰️",
                    region = "Serra Gaúcha, RS, BR",
                    severity = "ALTA",
                    description = "Movimentação de massa detectada por análise InSAR em encostas da Serra Gaúcha após chuvas intensas. Deslocamento de 12 mm/dia registrado. Evacuação preventiva recomendada.",
                    date = "21/05/2025 – 06:30",
                    satellite = "Sentinel-1A",
                    affectedAreaKm2 = 15.0,
                    status = "RESOLVIDO",
                    temperature = "18.0°C",
                    humidity = "88%",
                    windSpeed = "10 km/h"
                ),
                EnvironmentalEvent(
                    id = 7,
                    title = "Poluição Atmosférica – SP",
                    type = "Poluição",
                    typeEmoji = "💨",
                    region = "São Paulo, SP, BR",
                    severity = "MÉDIA",
                    description = "Sensor TROPOMI detectou concentração de NO₂ acima dos limites recomendados pela OMS na Região Metropolitana de São Paulo. Grupos de risco devem evitar exposição.",
                    date = "20/05/2025 – 13:00",
                    satellite = "Sentinel-5P",
                    affectedAreaKm2 = 7950.0,
                    status = "MONITORANDO",
                    temperature = "28.0°C",
                    humidity = "55%",
                    windSpeed = "8 km/h"
                ),
                EnvironmentalEvent(
                    id = 8,
                    title = "Mancha de Óleo – Litoral BA",
                    type = "Poluição",
                    typeEmoji = "🛢️",
                    region = "Litoral Baiano, BA, BR",
                    severity = "ALTA",
                    description = "Imagens SAR identificaram mancha de óleo com área de 120 km² no litoral baiano. Correntes oceânicas indicam deslocamento em direção às Áreas de Proteção Ambiental costeiras.",
                    date = "16/05/2025 – 07:00",
                    satellite = "Sentinel-1B",
                    affectedAreaKm2 = 120.0,
                    status = "ATIVO",
                    temperature = "29.0°C",
                    humidity = "78%",
                    windSpeed = "22 km/h"
                )
            )
        )
    }

    fun getSatellites(): SatelliteResponse {
        return SatelliteResponse(
            satellites = listOf(
                Satellite(
                    id = 1,
                    name = "CBERS-4A",
                    code = "CBERS-4A",
                    type = "Óptico",
                    typeEmoji = "🔭",
                    altitude = 628,
                    orbitType = "Heliosincrônica",
                    status = "Operacional",
                    launchDate = "28/12/2019",
                    agency = "INPE / CAST (BR/CN)",
                    coverageArea = "América do Sul e África",
                    instruments = listOf("WFI", "MUX", "WPM"),
                    lastPassTime = "26/05/2025 – 10:14",
                    nextPassTime = "26/05/2025 – 23:47"
                ),
                Satellite(
                    id = 2,
                    name = "Sentinel-2A/2B",
                    code = "S2A/S2B",
                    type = "Óptico",
                    typeEmoji = "🔭",
                    altitude = 786,
                    orbitType = "Heliosincrônica",
                    status = "Operacional",
                    launchDate = "23/06/2015",
                    agency = "ESA (EU)",
                    coverageArea = "Global",
                    instruments = listOf("MSI – 13 bandas espectrais"),
                    lastPassTime = "26/05/2025 – 09:32",
                    nextPassTime = "27/05/2025 – 09:29"
                ),
                Satellite(
                    id = 3,
                    name = "Sentinel-1A/1B",
                    code = "S1A/S1B",
                    type = "Radar SAR",
                    typeEmoji = "📡",
                    altitude = 693,
                    orbitType = "Heliosincrônica",
                    status = "Operacional",
                    launchDate = "03/04/2014",
                    agency = "ESA (EU)",
                    coverageArea = "Global",
                    instruments = listOf("SAR C-band", "InSAR"),
                    lastPassTime = "26/05/2025 – 02:08",
                    nextPassTime = "28/05/2025 – 02:04"
                ),
                Satellite(
                    id = 4,
                    name = "GOES-16",
                    code = "GOES-16",
                    type = "Meteorológico",
                    typeEmoji = "🌦️",
                    altitude = 35786,
                    orbitType = "Geoestacionária",
                    status = "Operacional",
                    launchDate = "19/11/2016",
                    agency = "NOAA / NASA (EUA)",
                    coverageArea = "Américas",
                    instruments = listOf("ABI", "GLM", "SUVI"),
                    lastPassTime = "Contínuo",
                    nextPassTime = "Contínuo"
                ),
                Satellite(
                    id = 5,
                    name = "Landsat-9",
                    code = "L9",
                    type = "Ambiental",
                    typeEmoji = "🌍",
                    altitude = 705,
                    orbitType = "Heliosincrônica",
                    status = "Operacional",
                    launchDate = "27/09/2021",
                    agency = "USGS / NASA (EUA)",
                    coverageArea = "Global",
                    instruments = listOf("OLI-2", "TIRS-2"),
                    lastPassTime = "25/05/2025 – 11:52",
                    nextPassTime = "10/06/2025 – 11:48"
                ),
                Satellite(
                    id = 6,
                    name = "Amazonia-1",
                    code = "AMZ-1",
                    type = "Ambiental",
                    typeEmoji = "🌍",
                    altitude = 752,
                    orbitType = "Heliosincrônica",
                    status = "Stand-by",
                    launchDate = "28/02/2021",
                    agency = "INPE (BR)",
                    coverageArea = "América do Sul",
                    instruments = listOf("WFI – Wide Field Imager"),
                    lastPassTime = "22/05/2025 – 14:05",
                    nextPassTime = "27/05/2025 – 14:01"
                )
            )
        )
    }

    fun getAlerts(): AlertResponse {
        return AlertResponse(
            alerts = listOf(
                EnvironmentalAlert(
                    id = 1,
                    title = "🔥 Incêndio CRÍTICO – Pantanal",
                    message = "Foco ativo detectado pelo CBERS-4A. Área afetada: 1.240 km². Vento de 42 km/h favorece propagação. AÇÃO IMEDIATA NECESSÁRIA.",
                    region = "Mato Grosso do Sul, BR",
                    severity = "CRÍTICA",
                    timestamp = "26/05/2025 – 14:35",
                    isRead = false
                ),
                EnvironmentalAlert(
                    id = 2,
                    title = "🌊 Enchente – Vale do Itajaí",
                    message = "Rio Itajaí-Açu 4,2m acima do nível normal. Evacuação recomendada para zonas de risco.",
                    region = "Santa Catarina, BR",
                    severity = "ALTA",
                    timestamp = "25/05/2025 – 09:20",
                    isRead = false
                ),
                EnvironmentalAlert(
                    id = 3,
                    title = "🌳 Desmatamento Ilegal – Pará",
                    message = "ALOS-2 identificou novo polígono de 890 km² em APA. IBAMA e Polícia Federal notificados.",
                    region = "Pará, BR",
                    severity = "ALTA",
                    timestamp = "23/05/2025 – 08:50",
                    isRead = true
                ),
                EnvironmentalAlert(
                    id = 4,
                    title = "☀️ Seca Severa – Nordeste",
                    message = "NDVI em mínimo histórico. Emergência hídrica declarada em 43 municípios.",
                    region = "Sertão Nordestino, BR",
                    severity = "ALTA",
                    timestamp = "24/05/2025 – 11:05",
                    isRead = false
                ),
                EnvironmentalAlert(
                    id = 5,
                    title = "💨 Poluição – Grande São Paulo",
                    message = "NO₂ acima do limite da OMS. Qualidade do ar PÉSSIMA. Grupos de risco devem evitar exposição.",
                    region = "São Paulo, SP, BR",
                    severity = "MÉDIA",
                    timestamp = "20/05/2025 – 13:10",
                    isRead = true
                ),
                EnvironmentalAlert(
                    id = 6,
                    title = "🛢️ Mancha de Óleo – Litoral BA",
                    message = "Mancha de 120 km² detectada. Correntes oceânicas levam em direção a APAs. Marinha acionada.",
                    region = "Litoral Baiano, BA, BR",
                    severity = "ALTA",
                    timestamp = "16/05/2025 – 07:05",
                    isRead = true
                )
            )
        )
    }
}
