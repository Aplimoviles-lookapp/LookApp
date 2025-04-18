package edu.unicauca.lookapp.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import edu.unicauca.lookapp.features.home.data.dao.ShiftDao
import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

@Database(
    entities =[
        ItemEntity::class,
        UserAccountEntity::class,
        UserAccounItemCrossRef::class,
        ShiftDao::class
    ],
    version = 6,
    exportSchema = false
)
abstract class LookAppDatabase:RoomDatabase() {
    abstract fun savedDao(): SavedDao
    abstract fun userAccountDao(): UserAccountDao
    abstract fun shiftDao():ShiftDao
}