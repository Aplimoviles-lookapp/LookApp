package edu.unicauca.lookapp.features.userprofile.data.datasource

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccountWithSavedItems
import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow

class RoomUserAccountLocalDataSourceImpl(private val userAccountDao: UserAccountDao) : UserAccountDataSource {
    override suspend fun insertUserAccount(userAccount: UserAccountEntity) {
        userAccountDao.insertUserAccount(userAccount)
    }

    override suspend fun insertAll(userAccounts: List<UserAccountEntity>) {
        userAccountDao.insertAll(userAccounts)
    }

    override suspend fun count(): Int {
        return userAccountDao.count()
    }

    override suspend fun deleteAll() {
        userAccountDao.deleteAll()
    }

    override fun getAll(): Flow<List<UserAccountEntity>> {
        return userAccountDao.getAll()
    }

    override suspend fun getById(userAccountId: Long): UserAccountEntity {
        return userAccountDao.getById(userAccountId)
    }

    override suspend fun getUserAccountWithItems(userAccountId: Long): UserAccountWithSavedItems {
        return userAccountDao.getUserAccountWithItems(userAccountId)
    }

    override suspend fun insertUserAccountWithItems(
        userAccount: UserAccountEntity,
        items: List<ItemEntity>
    ) {
        userAccountDao.insertUserAccountWithItems(userAccount, items)
    }

    override suspend fun insertCrossRef(ref: UserAccounItemCrossRef) {
        userAccountDao.insertCrossRef(ref)
    }

    override suspend fun insertCrossRefs(refs: List<UserAccounItemCrossRef>) {
        userAccountDao.insertCrossRefs(refs)
    }

    override suspend fun findFirst(): UserAccountEntity? {
        return userAccountDao.findFirst()
    }
}