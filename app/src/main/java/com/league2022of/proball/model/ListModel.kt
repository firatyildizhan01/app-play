package com.league2022of.proball.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "listmodel")
data class ListModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val teamOne: String?,
    val teamSecond: String?,
    val resultOne: String?,
    val resultTwo: String?,
    val resultText: String?
) : Parcelable
