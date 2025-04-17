package edu.unicauca.lookapp.features.userprofile.data.datasource

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccountWithSavedItems
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow

interface UserAccountDataSource {
    suspend fun insertUserAccount(userAccount: UserAccountEntity)
    suspend fun insertAll(userAccounts: List<UserAccountEntity>)
    suspend fun count(): Int
    suspend fun deleteAll()
    fun getAll(): Flow<List<UserAccountEntity>>
    suspend fun getById(userAccountId: Long): UserAccountEntity
    suspend fun getUserAccountWithItems(userAccountId: Long): UserAccountWithSavedItems
    suspend fun insertUserAccountWithItems(
        userAccount: UserAccountEntity,
        items: List<ItemEntity>
    )


    suspend fun insertCrossRef(ref: UserAccounItemCrossRef)
    suspend fun insertCrossRefs(refs: List<UserAccounItemCrossRef>)
    suspend fun findFirst(): UserAccountEntity?
}