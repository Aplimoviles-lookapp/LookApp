package edu.unicauca.lookapp.features.userprofile.data.repository

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.data.prepopulate.InitialSavedDataProvider
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.datasource.UserAccountDataSource
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import edu.unicauca.lookapp.features.userprofile.data.prepopulate.InitialUserAccountDataProvider
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserAccount
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserAccountRepository @Inject constructor(
    private val userAccountDataSource: UserAccountDataSource
) {
    suspend fun insertUserAccountWithItems(
        userAccount: UserAccountEntity,
        items: List<ItemEntity>
    ) {
        userAccountDataSource.insertUserAccountWithItems(userAccount, items)
    }

    suspend fun getUserAccountWithItems(userAccountId: Long) =
        userAccountDataSource.getUserAccountWithItems(userAccountId)

    suspend fun getUserAccountById(userAccountId: Long): UserAccountEntity {
        return userAccountDataSource.getById(userAccountId)
    }




    suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        userAccountDataSource.insertUserAccount(userAccount)
    }

    suspend fun loadInitialData(items: List<ItemEntity>) {
        if (userAccountDataSource.count() > 0) return
        val user: UserAccountEntity = InitialUserAccountDataProvider.getAccounts()[0]
        userAccountDataSource.insertUserAccount(user)

        val savedUser = userAccountDataSource.findFirst()

        if (savedUser != null) {
            userAccountDataSource.insertCrossRefs(
                items.map { item ->
                    UserAccounItemCrossRef(
                        userAccountId = savedUser.userAccountId,
                        itemId = item.itemId
                    )
                }
            )
        }

    }

    suspend fun count(): Int {
        return userAccountDataSource.count()
    }

    suspend fun deleteAll() {
        userAccountDataSource.deleteAll()
    }

    fun getAll() = userAccountDataSource.getAll().map { entities ->
        entities.map { entity ->
            UserAccount(
                id = entity.userAccountId,
                name = entity.name,
                email = entity.email,
                onClick = { callback-> callback(entity.userAccountId) }
            )
        }
    }
}