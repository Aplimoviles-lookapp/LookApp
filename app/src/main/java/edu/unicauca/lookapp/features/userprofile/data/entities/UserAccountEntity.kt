package edu.unicauca.lookapp.features.userprofile.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_accounts")
data class UserAccountEntity (
    @PrimaryKey(autoGenerate = true) val userAccountId: Long = 0,
    var name: String,
    val email: String,
)