package edu.unicauca.lookapp.features.userprofile.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.userprofile.domain.usecases.AddUserAccountUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.GetUserAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.SingnoutAllAccountsUseCase
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserAccount
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val addUserAccountUseCase: AddUserAccountUseCase,
    private val getUserAccountsUseCase: GetUserAccountsUseCase,
    private val singnoutAllAccountsUseCase: SingnoutAllAccountsUseCase,
    private val sessionManager: SessionManager,

    ) : ViewModel() {
    val currentUser = sessionManager.uiState

    fun addUserAccount() {
        viewModelScope.launch {
            addUserAccountUseCase()
        }
    }
    fun signoutAllAccounts() {
        viewModelScope.launch {
            singnoutAllAccountsUseCase()
        }
    }

    fun getUserAccounts() = getUserAccountsUseCase()
    fun updateUserAccount(userAccount: UserAccount?) {
        sessionManager.updateUserAccount(userAccount)
    }


    /*fun deleteItem(id: Long) {
        viewModelScope.launch {
            deleteSavedItemUseCase(id)
        }
    }*/
}

