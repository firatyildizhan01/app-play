package com.league2022of.proball.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "playermodel")
data class PlayerModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val imageUrl: Int,
    val playerName: String?,
    val attack: String?,
    val defence: String?,
    val goalie: String?,
    val role: String?,
    val roster: String?,
) : Parcelable
