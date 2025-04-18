package edu.unicauca.lookapp.features.userprofile.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccountWithSavedItems
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserAccountDao {


        @Transaction
        suspend fun insertUserAccountWithItems(
            userAccount: UserAccountEntity,
            items: List<ItemEntity>
        ) {
            insertUserAccount(userAccount)
            //insertAllItems(items)
            insertCrossRefs(
                items.map { item ->
                    UserAccounItemCrossRef(
                        userAccountId = userAccount.userAccountId,
                        itemId = item.itemId
                    )
                }
            )
        }
    @Transaction
    @Query("SELECT * FROM user_accounts WHERE userAccountId = :userAccountId")
    suspend fun getUserAccountWithItems(userAccountId: Long): UserAccountWithSavedItems

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRefs(refs: List<UserAccounItemCrossRef>)


    @Insert
    suspend fun insertCrossRef(ref: UserAccounItemCrossRef)


    //@Insert
    //suspend fun insertAllItems(items: List<ItemEntity>)

    @Insert
    suspend fun insertUserAccount(userAccount: UserAccountEntity)

    @Query("SELECT * FROM user_accounts WHERE userAccountId = :userAccountId")
    suspend fun getById(userAccountId: Long): UserAccountEntity

    @Query("SELECT * FROM user_accounts")
    fun getAll(): Flow<List<UserAccountEntity>>

    @Query("DELETE FROM user_accounts")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(accounts: List<UserAccountEntity>)

    @Query("SELECT COUNT(*) FROM user_accounts")
    suspend fun count(): Int

    @Query("SELECT * FROM user_accounts LIMIT 1")
    suspend fun findFirst(): UserAccountEntity?
}