# AETHER - Monitoramento Ambiental via Satélite

## Objetivo da Solução

O **AETHER** é um aplicativo Android desenvolvido em **Kotlin com Jetpack Compose** como parte da **Global Solution da FIAP**. A solução simula uma plataforma de monitoramento ambiental que utiliza dados de satélites para identificar e acompanhar eventos críticos no território brasileiro, como: queimadas, enchentes, secas, desmatamentos, deslizamentos e poluição atmosférica.

O app centraliza essas informações em painéis visuais, permitindo que usuários acompanhem ocorrências ativas, consultem alertas em aberto e visualizem os satélites responsáveis pela coleta dos dados.

---

## Entidades gerenciadas

| Entidade | Descrição |
|---|---|
| `EnvironmentalEvent` | Evento ambiental detectado por satélite (tipo, severidade, área afetada, dados climáticos) |
| `Satellite` | Satélite ativo com informações de órbita, altitude, instrumentos e cobertura |
| `EnvironmentalAlert` | Alerta crítico gerado a partir de um evento, com status de leitura |

---

## Telas

| Tela | Descrição |
|---|---|
| **Splash** | Tela de abertura com identidade visual do app |
| **Home** | Painel principal com estatísticas e eventos recentes |
| **Eventos** | Lista completa de eventos com filtros por tipo e severidade |
| **Detalhe do Evento** | Informações completas de um evento: satélite, área afetada, análise orbital e dados climáticos |
| **Satélites** | Catálogo dos satélites monitorados com filtro por status operacional |
| **Alertas** | Central de alertas com controle de lidos/não lidos |

---

## Telas (Screenshots)

<img width="383" height="854" alt="Home" src="https://github.com/user-attachments/assets/fcaf80a5-dfb6-4c7f-adcc-62aecfc15e70" />
<img width="380" height="851" alt="Tela de eventos ambientais" src="https://github.com/user-attachments/assets/f0f8aac7-ca74-4673-a101-31ce8d2c7986" />
<img width="378" height="854" alt="Tela em eventos ambientais mostrando filtro funcional" src="https://github.com/user-attachments/assets/a0c306ca-f5d2-44bd-90d6-4a2b4091afb4" />
<img width="378" height="851" alt="Tela de detalhes do evento" src="https://github.com/user-attachments/assets/d32bfba0-86b8-40fb-abfe-baf88d1e0687" />
<img width="380" height="850" alt="Tela de satélites" src="https://github.com/user-attachments/assets/aa96fc6c-b701-405b-8916-cda6c8ce6e48" />
<img width="374" height="849" alt="Tela de alertas (e notificação)" src="https://github.com/user-attachments/assets/1e4761cf-7f55-4792-8240-67545b2dd3a9" />

---

## Fluxo de Navegação

```
┌──────────┐
│  Splash  │ (2,5 seg → navega automaticamente)
└────┬─────┘
     ▼
┌──────────────────────────────────────────────────────┐
│                        Home                          │
│  [Eventos]         [Satélites]        [Alertas]      │
└────┬───────────────────┬───────────────────┬─────────┘
     ▼                   ▼                   ▼
┌─────────┐       ┌────────────┐      ┌──────────┐
│ Eventos │       │ Satélites  │      │ Alertas  │
└────┬────┘       └────────────┘      └──────────┘
     ▼
┌──────────────────┐
│ Detalhe do       │
│ Evento           │
└──────────────────┘
```

A navegação é feita com **Navigation Compose**. A tela Splash é removida do back stack ao entrar na Home, impedindo que o usuário retorne a ela. Nas demais telas, o botão de voltar retorna à tela anterior via `popBackStack()`. O acesso ao Detalhe do Evento pode ser feito tanto pela listagem de Eventos quanto pelos cards de eventos recentes na Home.
