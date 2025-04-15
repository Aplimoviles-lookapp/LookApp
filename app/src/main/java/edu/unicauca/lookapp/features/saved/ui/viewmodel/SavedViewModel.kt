package edu.unicauca.lookapp.features.saved.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import edu.unicauca.lookapp.features.saved.domain.usecases.GetSavedItemsUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.InsertSavedItemUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor (
    private val insertSavedItemUseCase: InsertSavedItemUseCase,
    private val loadInitialDataUseCase: LoadInitialDataUseCase,
    private val getSavedItemsUseCase: GetSavedItemsUseCase
): ViewModel() {

    fun insertItem(item: ItemEntity) {
        viewModelScope.launch {
            insertSavedItemUseCase(item)
        }
    }
    fun loadInitialData() {
        viewModelScope.launch {
            loadInitialDataUseCase()
        }
    }
    fun getSavedItems() = getSavedItemsUseCase()

}