package com.league2022of.proball.repository

import com.league2022of.proball.db.SportDao
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.model.PlayerModel
import com.league2022of.proball.model.SportModel
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

    //////////////////////////////////////////////////////

    suspend fun insertPlayer(player: PlayerModel) = sportDao.insertAllPlayer(player)

    suspend fun updatePlayer(id : Int, roster : String){
        sportDao.updatePlayer(id,roster)
    }

    suspend fun deletePlayer(player: PlayerModel) = sportDao.deletePlayer(player)

    fun getAllPlayer() = sportDao.getAllPlayer()
}