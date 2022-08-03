package com.league2022of.proball.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.model.PlayerModel
import com.league2022of.proball.model.SportModel
import com.league2022of.proball.repository.SportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportViewModel
@Inject
constructor(private val sportRepository: SportRepository) : ViewModel() {

    fun insertSport(sport: SportModel) = viewModelScope.launch {
        sportRepository.insertSport(sport) }

    fun deleteSport(sport: SportModel) = viewModelScope.launch {
        sportRepository.deleteSport(sport)}

    val allSport = sportRepository.getAllToDo().asLiveData()

    fun insertEvents(list: ListModel) = viewModelScope.launch {
        sportRepository.insertEvent(list) }

    fun updateEvents(id : Int, win : String){
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.updateEvent(id,win)
        }
    }

    fun deleteEvents(list: ListModel) = viewModelScope.launch {
        sportRepository.deleteEvent(list)}

    val allEvents = sportRepository.getAllEvent().asLiveData()

    ////////////////

    fun insertPlayer(player: PlayerModel) = viewModelScope.launch {
        sportRepository.insertPlayer(player) }

    fun updatePlayer(id : Int, roster : String){
        viewModelScope.launch(Dispatchers.IO) {
            sportRepository.updatePlayer(id,roster)
        }
    }

    fun deletePlayer(player: PlayerModel) = viewModelScope.launch {
        sportRepository.deletePlayer(player)}

    val allPlayer = sportRepository.getAllPlayer().asLiveData()
}
