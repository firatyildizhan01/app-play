package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Body(
    val events_list: List<Events>,
    val tournament_id: Int?,
    val tournament_name: String?
)