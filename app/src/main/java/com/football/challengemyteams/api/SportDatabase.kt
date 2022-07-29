package com.football.challengemyteams.api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.football.challengemyteams.db.SportDao
import com.football.challengemyteams.model.ListModel
import com.football.challengemyteams.model.SportModel

@Database(
    entities = [SportModel::class, ListModel::class],
    version = 1, exportSchema = false
)
abstract class SportDatabase : RoomDatabase() {

    abstract fun sportDao(): SportDao

}