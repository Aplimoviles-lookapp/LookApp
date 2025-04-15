package edu.unicauca.lookapp.features.saved.data.datasource

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

interface SavedLocalDataSource {
    suspend fun insertItem(item: ItemEntity)
    suspend fun deleteItem(item: ItemEntity)
    suspend fun insertAll(items: List<ItemEntity>)
    suspend fun count(): Int
    fun getAll(): Flow<List<ItemEntity>>
}