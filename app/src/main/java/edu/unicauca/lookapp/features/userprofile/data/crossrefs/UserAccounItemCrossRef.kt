package edu.unicauca.lookapp.features.userprofile.data.crossrefs

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

@Entity(
    tableName = "user_accounts_items_cross_ref",
    primaryKeys = ["userAccountId", "itemId"],
    indices = [
        Index(value = arrayOf("itemId")) // <-- Agregado
    ]
)
data class UserAccounItemCrossRef(
    var userAccountId: Long = 0L,
    var itemId: Long = 0L
)