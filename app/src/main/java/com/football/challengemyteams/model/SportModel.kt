package com.football.challengemyteams.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "sportmodel")
data class SportModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val sportTitle: String?
)
