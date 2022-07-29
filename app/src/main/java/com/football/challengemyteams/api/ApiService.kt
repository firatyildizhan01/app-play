package com.football.challengemyteams.api

import com.football.challengemyteams.model.Countries
import com.football.challengemyteams.model.ResponseApi
import com.football.challengemyteams.model.SportCategories
import com.football.challengemyteams.model.TournamentResponse
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