package com.league2022of.proball.repository

import com.league2022of.proball.api.ApiService
import javax.inject.Inject

class ApiRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getSpors(sport_id: String, tournament_id: String) = apiService.getAllSport(sport_id,tournament_id)
    suspend fun getCountries(sport_id : String) = apiService.getAllCountries(sport_id)
    suspend fun getSportCategories() = apiService.getAllSportCategories()
    suspend fun getSpoyer() = apiService.getAllSpoyer()
    suspend fun getSpecificSport(game_id : String) = apiService.getSpecificSport(game_id)
    suspend fun getTournaments(sport_id: String, country_id: String) = apiService.getTournaments(sport_id,country_id)
}