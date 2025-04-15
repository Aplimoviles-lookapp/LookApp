package edu.unicauca.lookapp.features.saved.domain.usecases

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import javax.inject.Inject

class InsertSavedItemUseCase @Inject constructor(private val savedRepository: SavedRepository) {
    suspend operator fun invoke(item: ItemEntity) { //Must not be from db but from domain and mapped to entity but ill leave it like this
        savedRepository.insertItem(item)
    }
}