package edu.unicauca.lookapp.features.userprofile.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class UserAccount(
    var id: Long = 0L,
    val name: String,
    val email: String,
    val onClick : ((Long)->Unit) -> Unit = {},
) {
}