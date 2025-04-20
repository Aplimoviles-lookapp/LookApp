package edu.unicauca.lookapp.features.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity

@Dao
interface ServiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(services: List<ServiceEntity>)
    @Query("SELECT COUNT(*) FROM services")
    suspend fun count(): Int
}