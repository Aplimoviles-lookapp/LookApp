package edu.unicauca.lookapp.features.saved.data.repositories

import edu.unicauca.lookapp.features.saved.data.datasource.SavedLocalDataSource
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.prepopulate.InitialSavedDataProvider
import javax.inject.Inject

class SavedRepository @Inject constructor(private val savedLocalDataSource: SavedLocalDataSource) {

    suspend fun insertItem(item: ItemEntity) {
        savedLocalDataSource.insertItem(item)
    }

    suspend fun deleteItem(id: Long) {
        savedLocalDataSource.deleteItem(id)
    }

    suspend fun loadInitialData(){
        if(savedLocalDataSource.count() > 0) return
        savedLocalDataSource.insertAll(InitialSavedDataProvider.getItems())
    }

    fun getAll()= savedLocalDataSource.getAll()
}