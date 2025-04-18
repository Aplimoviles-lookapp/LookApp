package edu.unicauca.lookapp.features.saved.data.datasource

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

interface SavedDataSource {
    suspend fun insertItem(item: ItemEntity)
    suspend fun deleteItem(id: Long)
    suspend fun insertAll(items: List<ItemEntity>)
    suspend fun count(): Int
    fun getAll(): Flow<List<ItemEntity>>
    fun getItemsByUserAccountId(userAccountId: Long): Flow<List<ItemEntity>>
}