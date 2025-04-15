package edu.unicauca.lookapp.features.saved.domain.usecases

import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import javax.inject.Inject

class LoadInitialDataUseCase @Inject constructor(
    private val savedRepository: SavedRepository
) {
    suspend operator fun invoke() {
        savedRepository.loadInitialData()
    }
}