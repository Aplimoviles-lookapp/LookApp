package edu.unicauca.lookapp.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity

@Database(
    entities =[
        ItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LookAppDatabase:RoomDatabase() {
    abstract fun savedDao(): SavedDao
}