package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import kotlinx.coroutines.flow.Flow

interface ShiftDataSource {
    suspend fun insertShift(shift: ShiftEntity)
    fun getAll(): Flow<List<ShiftEntity>>
}