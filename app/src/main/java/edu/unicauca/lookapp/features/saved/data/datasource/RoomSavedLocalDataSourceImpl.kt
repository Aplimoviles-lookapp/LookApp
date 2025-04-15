package edu.unicauca.lookapp.features.saved.data.datasource

import androidx.lifecycle.asLiveData
import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class RoomSavedLocalDataSourceImpl (private val savedDao: SavedDao): SavedLocalDataSource {
    override suspend fun insertItem(item: ItemEntity) {
        savedDao.insertItem(item)
    }

    override suspend fun deleteItem(item: ItemEntity) {
        savedDao.deleteItem(item)
    }

    override suspend fun insertAll(items: List<ItemEntity>) {
        savedDao.insertAll(items)
    }

    override suspend fun count(): Int {
        return savedDao.count()
    }

    override fun getAll(): Flow<List<ItemEntity>> {
        return savedDao.getAll()
    }
}