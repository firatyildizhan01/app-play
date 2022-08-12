package com.league2022of.proball.api

import com.league2022of.proball.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/events/{sport_id}/{tournament_id}/sub/100/live/en")
    suspend fun getAllSport(
        @Path("sport_id") sport_id: String,
        @Path("tournament_id") tournament_id: String
    ): Response<ResponseApi>

    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/countries/{sport_id}/live/en")
    suspend fun getAllCountries(
        @Path("sport_id") game_id: String
    ): Response<Countries>

    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/sports/live/en")
    suspend fun getAllSportCategories(
    ): Response<SportCategories>


    @GET("api/en/get.php?login=ayna&token=12784-OhJLY5mb3BSOx0O&task=livedata&sport=soccer")
    suspend fun getAllSpoyer(
    ): Response<SpoyerResult>

    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/event/{game_id}/list/live/en")
    suspend fun getSpecificSport(
        @Path("game_id") game_id: String
    ): Response<ResponseApi>

    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/tournaments/{sport_id}/{country_id}/live/en")
    suspend fun getTournaments(
        @Path("sport_id") sport_id: String,
        @Path("country_id") country_id: String
    ): Response<TournamentResponse>
}