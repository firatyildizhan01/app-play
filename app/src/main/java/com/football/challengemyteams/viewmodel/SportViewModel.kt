package com.football.challengemyteams.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.football.challengemyteams.model.ListModel
import com.football.challengemyteams.model.SportModel
import com.football.challengemyteams.repository.SportRepository
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
}
