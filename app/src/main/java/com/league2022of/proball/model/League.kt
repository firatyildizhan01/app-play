package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class League(
    val cc: String?,
    val id: String?,
    val name: String?
)