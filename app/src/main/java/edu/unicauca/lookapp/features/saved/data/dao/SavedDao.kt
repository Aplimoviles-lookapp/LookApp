package edu.unicauca.lookapp.features.saved.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedDao {
    // Define your database operations here
    // For example:
    @Insert
    suspend fun insertItem(item: ItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ItemEntity>)

    @Query("DELETE FROM items WHERE itemId = :id")
    suspend fun deleteItem(id: Long)

    @Query("SELECT COUNT(*) FROM items")
    suspend fun count(): Int

    @Query("SELECT * FROM items")
    fun getAll(): Flow<List<ItemEntity>>

    @Query("""
        SELECT items.*
        FROM items AS items
        INNER JOIN user_accounts_items_cross_ref AS cross_ref
        ON items.itemId = cross_ref.itemId
        WHERE cross_ref.userAccountId = :userAccountId
    """)
    fun getItemsByUserAccountId(userAccountId: Long): Flow<List<ItemEntity>>
}