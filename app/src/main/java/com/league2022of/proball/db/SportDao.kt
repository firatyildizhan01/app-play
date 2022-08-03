package com.league2022of.proball.db

import androidx.room.*
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.model.PlayerModel
import com.league2022of.proball.model.SportModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(sport: SportModel)

    @Delete
    suspend fun deleteToDo(sport: SportModel)

    @Query("SELECT * FROM sportmodel ORDER BY sportTitle ASC ")
    fun getAllToDos(): Flow<List<SportModel>>

    @Query("UPDATE listmodel SET teamOne = :win WHERE id = :id")
    fun updateEvent(id: Int, win:String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSport(list: ListModel)

    @Delete
    suspend fun deleteSport(list: ListModel)

    @Query("SELECT * FROM listmodel ORDER BY id ASC ")
    fun getAllSport(): Flow<List<ListModel>>

    @Query("UPDATE playermodel SET roster = :roster WHERE id = :id")
    fun updatePlayer(id: Int, roster:String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlayer(player: PlayerModel)

    @Delete
    suspend fun deletePlayer(player: PlayerModel)

    @Query("SELECT * FROM playermodel ORDER BY id ASC ")
    fun getAllPlayer(): Flow<List<PlayerModel>>
}