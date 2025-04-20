package edu.unicauca.lookapp.features.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ShiftDao {

    @Insert
    suspend fun insertShift(shift: ShiftEntity)
    @Query("SELECT * FROM shift")

    fun getAll(): Flow<List<ShiftEntity>>

}