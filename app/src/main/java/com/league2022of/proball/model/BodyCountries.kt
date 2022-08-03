package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyCountries(
    val counter: Int?,
    val id: Int?,
    val name: String?,
    val name_en: String?,
    val name_ru: String?,
    val sport_id: Int?
)