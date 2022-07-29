package com.football.challengemyteams.model

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
    val nameOne: String?,
    val nameSecond: String?,
    val rateOne: String?,
    val rateTwo: String?,
    val calendar: String?,
    var score : String?,
    val teamCount : Int?,
    val win : Int?
) : Parcelable
