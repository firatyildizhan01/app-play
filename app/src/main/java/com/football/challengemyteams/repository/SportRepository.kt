package com.football.challengemyteams.repository

import com.football.challengemyteams.db.SportDao
import com.football.challengemyteams.model.ListModel
import com.football.challengemyteams.model.SportModel
import javax.inject.Inject

class SportRepository
@Inject
constructor(private val sportDao: SportDao) {

    suspend fun insertSport(sport: SportModel) = sportDao.insertToDo(sport)

    suspend fun deleteSport(sport: SportModel) = sportDao.deleteToDo(sport)

    fun getAllToDo() = sportDao.getAllToDos()

    suspend fun insertEvent(list: ListModel) = sportDao.insertAllSport(list)

    suspend fun updateEvent(id : Int, win : String){
        sportDao.updateEvent(id,win)
    }

    suspend fun deleteEvent(list: ListModel) = sportDao.deleteSport(list)

    fun getAllEvent() = sportDao.getAllSport()
}