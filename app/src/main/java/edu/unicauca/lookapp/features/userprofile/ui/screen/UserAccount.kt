package edu.unicauca.lookapp.features.userprofile.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class UserAccount(
    val name: String,
    val email: String,
    isCurrentUser: Boolean = false
) {
    var current by mutableStateOf(isCurrentUser)
}