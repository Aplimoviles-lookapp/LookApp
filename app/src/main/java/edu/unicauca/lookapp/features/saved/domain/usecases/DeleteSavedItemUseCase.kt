package edu.unicauca.lookapp.features.saved.domain.usecases

import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import javax.inject.Inject

class DeleteSavedItemUseCase @Inject constructor(
    private val savedRepository: SavedRepository
) {
    suspend operator fun invoke(id: Long) = savedRepository.deleteItem(id)
}