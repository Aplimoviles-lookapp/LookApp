package edu.unicauca.lookapp.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.unicauca.lookapp.features.home.data.dao.ServiceDao
import edu.unicauca.lookapp.features.home.data.dao.ShiftDao
import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef
import edu.unicauca.lookapp.features.notifications.data.dao.NotificationDao
import edu.unicauca.lookapp.features.notifications.data.entities.NotificationEntity


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
        ShiftEntity::class,
        SiteEntity::class,
        ServiceEntity::class,
        SiteServiceCrossRef::class,
        NotificationEntity::class
    ],
    version = 10,
    exportSchema = false
)
abstract class LookAppDatabase:RoomDatabase() {
    abstract fun savedDao(): SavedDao
    abstract fun userAccountDao(): UserAccountDao
    abstract fun shiftDao(): ShiftDao
    abstract fun siteDao():SiteDao
    abstract fun serviceDao():ServiceDao
    abstract fun notificationDao(): NotificationDao
}