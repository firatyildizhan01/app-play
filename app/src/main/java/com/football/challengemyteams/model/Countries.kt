package com.football.challengemyteams.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Countries(
    val body: List<BodyCountries>,
    val page: String?,
    val status: Int?
)