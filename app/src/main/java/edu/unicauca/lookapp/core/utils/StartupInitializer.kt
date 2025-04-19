package edu.unicauca.lookapp.core.utils

import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialSavedItemsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.LoadInitialUserAccountsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StartupInitializer @Inject constructor(
    private val loadInitialSavedItemsUseCase: LoadInitialSavedItemsUseCase,
    private val loadInitialUserAccountsUseCase: LoadInitialUserAccountsUseCase
) {
    fun initialize() {

        CoroutineScope(Dispatchers.IO).launch{
            loadInitialSavedItemsUseCase() // Inserta Items primero
            loadInitialUserAccountsUseCase() // Luego crea usuarios con esos Items
        }

    }
}