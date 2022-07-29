package com.football.challengemyteams.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SportCategories(
    val body: List<BodySportCategories>,
    val page: String?,
    val status: Int?
)