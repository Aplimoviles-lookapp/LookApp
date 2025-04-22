package edu.unicauca.lookapp.features.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef
import edu.unicauca.lookapp.features.home.data.entities.SiteWithService
import edu.unicauca.lookapp.features.userprofile.data.crossrefs.UserAccounItemCrossRef
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface SiteDao {
    @Query("SELECT * FROM sites")
    fun getAllSites(): Flow<List<SiteEntity>>

    @Transaction
    @Query("SELECT * FROM sites WHERE siteId= :siteId")
    suspend fun getSiteWithServices(siteId:Long):SiteWithService

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sites: List<SiteEntity>)

    @Query("SELECT COUNT(*) FROM sites")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSiteServiceCrossRefs(refs: List<SiteServiceCrossRef>)

    @Query("SELECT * FROM sites LIMIT 1")
    suspend fun findFirst(): SiteEntity?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRef(ref:List<SiteServiceCrossRef>)
}