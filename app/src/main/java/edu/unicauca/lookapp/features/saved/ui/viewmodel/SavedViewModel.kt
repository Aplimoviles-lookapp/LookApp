package edu.unicauca.lookapp.features.saved.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.domain.usecases.DeleteSavedItemUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.GetSavedItemsUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.InsertSavedItemUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialSavedItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedViewModel @Inject constructor (
    private val insertSavedItemUseCase: InsertSavedItemUseCase,
    private val loadInitialDataUseCase: LoadInitialSavedItemsUseCase,
    private val getSavedItemsUseCase: GetSavedItemsUseCase,
    private val deleteSavedItemUseCase: DeleteSavedItemUseCase,
    val sessionManager: SessionManager,
): ViewModel() {

    val currentUser = sessionManager.uiState

    fun insertItem(item: ItemEntity) {
        viewModelScope.launch {
            insertSavedItemUseCase(item)
        }
    }

    /*fun loadInitialData() {
        viewModelScope.launch {
            loadInitialDataUseCase()
        }
    }*/
    fun getSavedItems(): Flow<List<ItemEntity>> {
        return getSavedItemsUseCase(sessionManager.uiState.value.currentUserAccount?.id ?: 0)
    }

    fun deleteItem(id: Long) {
        viewModelScope.launch {
            deleteSavedItemUseCase(id)
        }
    }



}