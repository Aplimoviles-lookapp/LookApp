package edu.unicauca.lookapp.features.saved.domain.usecases

import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import javax.inject.Inject

class GetSavedItemsUseCase @Inject constructor(
    private val savedRepository: SavedRepository
) {
    operator fun invoke() = savedRepository.getAll()
}