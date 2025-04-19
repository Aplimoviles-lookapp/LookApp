package edu.unicauca.lookapp.features.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import edu.unicauca.lookapp.features.home.domain.usecases.InsertShiftUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShiftViewModel @Inject constructor (
    private val insertShiftUseCase: InsertShiftUseCase
): ViewModel(){

    fun insertShift(shift:ShiftEntity){
        viewModelScope.launch {
            insertShiftUseCase(shift)
        }

    }

}