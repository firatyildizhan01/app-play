package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodySportCategories(
    val counter: Int?,
    val id: Int?,
    val name: String?,
    val name_en: String?,
    val name_ru: String?
)