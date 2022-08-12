package com.league2022of.proball.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Away(
    val cc: String?,
    val id: String?,
    val image_id: String?,
    val name: String?
)