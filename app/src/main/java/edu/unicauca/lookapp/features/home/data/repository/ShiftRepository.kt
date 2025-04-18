package edu.unicauca.lookapp.features.home.data.repository

import edu.unicauca.lookapp.features.home.data.datasource.ShiftDataSource
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import javax.inject.Inject

class ShiftRepository @Inject constructor(private val shiftDataSource:ShiftDataSource){

    suspend fun insertShift(shift:ShiftEntity){
        shiftDataSource.insertShift(shift)
    }
    fun getAll()=shiftDataSource.getAll()
}