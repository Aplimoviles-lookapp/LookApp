package edu.unicauca.lookapp.features.userprofile.data.crossrefs

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

data class UserAccountWithSavedItems(
    @Embedded val user: UserAccountEntity,
    @Relation(
        parentColumn = "userAccountId",
        entityColumn = "itemId",  // Relaciona el itemId de ItemEntity con el savedItemId en la tabla intermedia
        associateBy = Junction(
            value = UserAccounItemCrossRef::class,
            parentColumn = "userAccountId",
            entityColumn = "itemId" // Relaciona con el campo savedItemId
        )
    )
    val savedItems: List<ItemEntity>
)