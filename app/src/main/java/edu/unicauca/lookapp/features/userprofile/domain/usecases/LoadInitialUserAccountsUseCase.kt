package edu.unicauca.lookapp.features.userprofile.domain.usecases

import android.util.Log
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.repositories.SavedRepository
import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LoadInitialUserAccountsUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository,
    private val savedRepository: SavedRepository
) {
    suspend operator fun invoke() {

        val items = savedRepository.getAll().first()
        Log.d("LoadInitialUserAccountsUseCase", "Items: $items")
        userAccountRepository.loadInitialData(items)
    }
}