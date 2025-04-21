package edu.unicauca.lookapp.features.search.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.search.domain.usecases.GetCurrentLocationCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getCurrentLocationUseCase: GetCurrentLocationCase
): ViewModel() {

    private val _location = MutableStateFlow<Location?>(null)
    val location: StateFlow<Location?> = _location

    fun fetchLocation() {
        viewModelScope.launch {
            _location.value = getCurrentLocationUseCase()
        }
    }
}

