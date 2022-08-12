package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesLive(
    val away: Away,
    val bet365_id: String?,
    val game_id: String?,
    val home: Home,
    val league: League,
    val score: String?,
    val time: String?,
    val time_status: String?,
    val timer: String?
)