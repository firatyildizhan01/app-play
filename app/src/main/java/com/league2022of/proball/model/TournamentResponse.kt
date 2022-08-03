package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TournamentResponse(
    val body: List<BodyTournament>,
    val page: String?,
    val status: Int?
)