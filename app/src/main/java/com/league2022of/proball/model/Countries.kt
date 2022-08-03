package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Countries(
    val body: List<BodyCountries>,
    val page: String?,
    val status: Int?
)