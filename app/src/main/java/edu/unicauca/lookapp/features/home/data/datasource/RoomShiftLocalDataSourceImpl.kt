package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.dao.ShiftDao
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import kotlinx.coroutines.flow.Flow

class RoomShiftLocalDataSourceImpl(private val shiftDao: ShiftDao) : ShiftDataSource {
    override suspend fun insertShift(shift: ShiftEntity) {
        shiftDao.insertShift(shift)
    }

    override fun getAll(): Flow<List<ShiftEntity>> {
        return shiftDao.getAll()
    }
}