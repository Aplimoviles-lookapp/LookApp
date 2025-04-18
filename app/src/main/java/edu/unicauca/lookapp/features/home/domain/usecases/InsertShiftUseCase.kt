package edu.unicauca.lookapp.features.home.domain.usecases

import edu.unicauca.lookapp.features.home.data.entities.ShiftEntity
import edu.unicauca.lookapp.features.home.data.repository.ShiftRepository
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import javax.inject.Inject

class InsertShiftUseCase @Inject constructor(private val shiftRepository:ShiftRepository) {
    suspend operator fun invoke(shift: ShiftEntity) { //Must not be from db but from domain and mapped to entity but ill leave it like this
        shiftRepository.insertShift(shift)
    }
}