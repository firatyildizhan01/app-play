package com.football.challengemyteams.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseApi(
    val body: List<Body>,
    val page: String?,
    val status: Int?
)