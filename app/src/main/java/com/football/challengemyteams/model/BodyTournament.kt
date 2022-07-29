package com.football.challengemyteams.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyTournament(
    val counter: Int?,
    val country_id: Int?,
    val id: Int?,
    val name: String?,
    val name_en: String?,
    val name_ru: String?,
    val sport_id: Int?
)