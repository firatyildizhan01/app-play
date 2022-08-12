package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpoyerResult(
    val capacity_requests: String?,
    val games_live: List<GamesLive>,
    val last_time_your_key: String?,
    val remain_requests: String?,
    val time_request: Double
)