package com.football.challengemyteams.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.football.challengemyteams.api.ApiService
import com.football.challengemyteams.model.Countries
import com.football.challengemyteams.model.ResponseApi
import com.football.challengemyteams.model.SportCategories
import com.football.challengemyteams.model.TournamentResponse
import com.football.challengemyteams.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel
@Inject
constructor(private val repository: ApiRepository,    private val apiService: ApiService
) : ViewModel() {


    val countryId = MutableLiveData<String>()
    val loadingSpor = MutableLiveData<Boolean>()


    private val _response = MutableLiveData<ResponseApi>()
    private val _responseCountries = MutableLiveData<Countries>()
    private val _responseSportCategories = MutableLiveData<SportCategories>()
    private val _responseAll = MutableLiveData<ResponseApi>()
    private val _responseAllTournaments = MutableLiveData<TournamentResponse>()

    val sportResponse: LiveData<ResponseApi> = _response
    val sportResponseCountries: LiveData<Countries> = _responseCountries
    val sportResponseCategories: LiveData<SportCategories> = _responseSportCategories
    val sportResponseTournament: LiveData<TournamentResponse> = _responseAllTournaments

    init {
        getSporsCategories()
    }

     fun getSpors(sport_id: String,tournament_id: String) = viewModelScope.launch {
        repository.getSpors(sport_id,tournament_id).let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
                loadingSpor.value = true

            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
                loadingSpor.value = false

            }
        }
    }

    fun getAllCountries(sport_id : String) = viewModelScope.launch {
        repository.getCountries(sport_id).let { response ->

            if (response.isSuccessful) {
                _responseCountries.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

    private fun getSporsCategories() = viewModelScope.launch {
        repository.getSportCategories().let { response ->

            if (response.isSuccessful) {
                _responseSportCategories.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }


     fun getSpecificSport(game_id : String) = viewModelScope.launch {
        repository.getSpecificSport(game_id).let { response ->

            if (response.isSuccessful) {
                _responseAll.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

     fun getTournaments(sport_id : String, country_id : String) = viewModelScope.launch {
        repository.getTournaments(sport_id, country_id).let { response ->

            if (response.isSuccessful) {
                _responseAllTournaments.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

}