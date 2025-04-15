package edu.unicauca.lookapp.features.saved.data.repositories

import edu.unicauca.lookapp.features.saved.data.datasource.SavedLocalDataSource
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.prepopulate.InitialSavedDataProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedRepository @Inject constructor(private val savedLocalDataSource: SavedLocalDataSource) {

    suspend fun insertItem(item: ItemEntity) {
        savedLocalDataSource.insertItem(item)
    }

    suspend fun deleteItem(item: ItemEntity) {
        savedLocalDataSource.deleteItem(item)
    }

    suspend fun loadInitialData(){
        if(savedLocalDataSource.count() > 0) return
        savedLocalDataSource.insertAll(InitialSavedDataProvider.getItems())
    }

    fun getAll()= savedLocalDataSource.getAll()
}