package com.football.challengemyteams.db

import androidx.room.*
import com.football.challengemyteams.model.ListModel
import com.football.challengemyteams.model.SportModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(sport: SportModel)

    @Delete
    suspend fun deleteToDo(sport: SportModel)

    @Query("SELECT * FROM sportmodel ORDER BY sportTitle ASC ")
    fun getAllToDos(): Flow<List<SportModel>>

    @Query("UPDATE listmodel SET win = :win WHERE id = :id")
    fun updateEvent(id: Int, win:String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSport(list: ListModel)

    @Delete
    suspend fun deleteSport(list: ListModel)

    @Query("SELECT * FROM listmodel ORDER BY id ASC ")
    fun getAllSport(): Flow<List<ListModel>>
}