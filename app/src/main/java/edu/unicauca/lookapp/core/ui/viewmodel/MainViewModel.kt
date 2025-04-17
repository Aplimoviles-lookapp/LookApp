package edu.unicauca.lookapp.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialSavedItemsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor (
    private val loadInitialSavedItemsUseCase: LoadInitialSavedItemsUseCase, //Add here ur initialization use case
): ViewModel(){

    fun loadInitialData() {
        // This function is called when the app starts to load initial data
        // they must be launched in their own coroutine scope sequeentially
        viewModelScope.launch {
            loadInitialSavedItemsUseCase()
        }
    }

}