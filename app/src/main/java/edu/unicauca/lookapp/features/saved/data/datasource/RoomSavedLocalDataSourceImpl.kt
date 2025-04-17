package edu.unicauca.lookapp.features.saved.data.datasource

import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

class RoomSavedLocalDataSourceImpl (private val savedDao: SavedDao): SavedDataSource {
    override suspend fun insertItem(item: ItemEntity) {
        savedDao.insertItem(item)
    }



    override suspend fun deleteItem(id: Long) {
        savedDao.deleteItem(id)
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

    override fun getItemsByUserAccountId(userAccountId: Long): Flow<List<ItemEntity>> {
        return savedDao.getItemsByUserAccountId(userAccountId)
    }
}