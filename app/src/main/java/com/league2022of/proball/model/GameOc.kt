package com.league2022of.proball.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


import com.squareup.moshi.JsonClass
@Parcelize
@JsonClass(generateAdapter = true)
data class GameOc(
    val oc_block: Boolean?,
    val oc_group_name: String?,
    val oc_name: String?,
    val oc_pointer: String?,
    val oc_rate: Double?
): Parcelable