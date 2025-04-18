package edu.unicauca.lookapp.features.saved.data.repositories

import edu.unicauca.lookapp.features.saved.data.datasource.SavedDataSource
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.prepopulate.InitialSavedDataProvider
import javax.inject.Inject

class SavedRepository @Inject constructor(private val savedDataSource: SavedDataSource) {

    suspend fun insertItem(item: ItemEntity) {
        savedDataSource.insertItem(item)
    }

    suspend fun deleteItem(id: Long) {
        savedDataSource.deleteItem(id)
    }

    suspend fun loadInitialData(){
        if(savedDataSource.count() > 0) return
        savedDataSource.insertAll(InitialSavedDataProvider.getSavedItems())
    }

    fun getAll()= savedDataSource.getAll()

    fun getItemsByUserAccountId(userAccountId: Long) =
        savedDataSource.getItemsByUserAccountId(userAccountId)
}