package com.league2022of.proball.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.league2022of.proball.model.ListModel
import com.league2022of.proball.model.PlayerModel
import com.league2022of.proball.model.SportModel

@Database(
    entities = [SportModel::class, ListModel::class, PlayerModel::class],
    version = 1, exportSchema = false
)
abstract class SportDatabase : RoomDatabase() {

    abstract fun sportDao(): SportDao

}