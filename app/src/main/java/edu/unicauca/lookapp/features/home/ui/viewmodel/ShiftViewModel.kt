package edu.unicauca.lookapp.features.home.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.domain.usecases.GetAllSites
import edu.unicauca.lookapp.features.home.domain.usecases.GetSiteWithServices
import edu.unicauca.lookapp.features.home.domain.usecases.InsertShiftUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ShiftViewModel @Inject constructor (
    private val insertShiftUseCase: InsertShiftUseCase,
    private val getAllSites:GetAllSites,
    private val getSiteServices:GetSiteWithServices
): ViewModel() {

    var shiftUiState by mutableStateOf(ShiftUiState())
    var sitios by mutableStateOf<List<Site>>(emptyList())
    var servicios by mutableStateOf<List<String>>(emptyList())
    var showConfirmationDialog by mutableStateOf(false)


    init {
        getSitios()
    }

    private fun getSitios() {
        viewModelScope.launch {
            sitios = getAllSites().first().map { it.toSite() }
        }
    }

    fun onSelectNegocio(nombreNegocio: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(
                negocio = nombreNegocio,
                servicio = ""
            )
        )
        val sitioSeleccionado = sitios.find { it.name == nombreNegocio }

        sitioSeleccionado?.siteId?.let { siteId ->
            viewModelScope.launch {
                val siteWithServices = getSiteServices(siteId)
                servicios = siteWithServices.services.map { it.name }
            }
        }

    }

    fun onSelectServicio(nombreServicio: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(servicio = nombreServicio)
        )
    }

    fun insertShift() {
        viewModelScope.launch {
            val shiftEntity = shiftUiState.shiftDetails.toShiftEntity()
            insertShiftUseCase(shiftEntity)
        }
    }

    fun updateNombre(nombre: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(nombre = nombre)
        )
    }

    fun updateServicio(servicio: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(servicio = servicio)
        )
    }

    fun updateNegocio(negocio: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(negocio = negocio)
        )
    }

    fun updateFecha(fecha: Date) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(fecha = fecha)
        )
    }

    fun updateHorario(horario: String) {
        shiftUiState = shiftUiState.copy(
            shiftDetails = shiftUiState.shiftDetails.copy(horario = horario)
        )
    }

    fun clearForm() {
        shiftUiState = shiftUiState.copy(
            shiftDetails = ShiftDetails(
                nombre = "",
                servicio = "",
                negocio = "",
                fecha = null,
                horario = ""
            )
        )
    }
    fun showDialog() {
        showConfirmationDialog = true
    }

    fun dismissDialog() {
        showConfirmationDialog = false
    }

}


    data class ShiftUiState(
        val shiftDetails: ShiftDetails = ShiftDetails(),
        val isEntryValid: Boolean = false
    )
    data class Site(
        val siteId: Long ,
        val name:String,
        val address:String,
        val numberPhone:String
    )

    data class ShiftDetails(
        val nombre: String = "",
        val servicio: String = "",
        val negocio: String = "",
        val fecha: Date? = null,
        val horario: String = ""
    )


    fun ShiftDetails.toShiftEntity(): ShiftEntity {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return ShiftEntity(
            nameAndLastName = nombre,
            businessName = negocio,
            date = fecha?.let { dateFormat.format(it) } ?: "",
            time = horario
        )
    }

    fun ShiftEntity.toShiftUiState(isEntryValid: Boolean = false): ShiftUiState {
        return ShiftUiState(
            shiftDetails = this.toShiftDetails(),
            isEntryValid = isEntryValid
        )
    }

    fun ShiftEntity.toShiftDetails(): ShiftDetails {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedDate = try {
            dateFormat.parse(this.date)
        } catch (e: Exception) {
            null
        }

        return ShiftDetails(
            nombre = nameAndLastName,
            negocio = businessName,
            fecha = parsedDate,
            horario = time
        )
    }
    fun SiteEntity.toSite(): Site {
        return Site(
            siteId = siteId,
            name = name,
            address = address,
            numberPhone = numberPhone
        )
    }
