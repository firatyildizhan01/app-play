package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stat(
    val Key: String?,
    val Value: String?
)