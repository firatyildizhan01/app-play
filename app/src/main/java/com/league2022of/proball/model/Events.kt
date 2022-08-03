package com.league2022of.proball.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class Events(
    val chain_id: String?,
    val country_id: Int?,
    val country_name: String?,
    val ext_game_id: Int?,
    val extra_time: String?,
    val finale: Boolean,
    val game_desk: String?,
    val game_dop_name: String?,
    val game_id: Int?,
    val game_mid: Int?,
    val game_num: Int?,
    val game_oc_counter: Int?,
    val game_oc_list:  @RawValue List<GameOc>,
    val game_plan: String?,
    val game_start: Int?,
    val opp_1_icon: Int?,
    val opp_1_id: Int?,
    val opp_1_ids: List<Int>,
    val opp_1_name: String?,
    val opp_1_name_en: String?,
    val opp_1_name_ru: String?,
    val opp_2_icon: Int?,
    val opp_2_id: Int?,
    val opp_2_ids: List<Int>,
    val opp_2_name: String?,
    val opp_2_name_en: String?,
    val opp_2_name_ru: String?,
    val period_name: String?,
    val score_extra: String?,
    val score_full: String?,
    val score_period: String?,
    val sport_id: Int?,
    val sport_name: String?,
    val sport_name_en: String?,
    val sport_name_ru: String?,
    val stat_list: @RawValue List<Stat>,
    val stat_list_extra: @RawValue List<Any>,
    val timer: Int?,
    val tournament_id: Int?,
    val tournament_name: String?,
    val tournament_name_en: String?,
    val tournament_name_ru: String?,
    val uniq: String?
) : Parcelable