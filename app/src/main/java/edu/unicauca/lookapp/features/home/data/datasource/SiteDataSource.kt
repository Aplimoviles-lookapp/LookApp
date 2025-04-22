package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef
import edu.unicauca.lookapp.features.home.data.entities.SiteWithService
import kotlinx.coroutines.flow.Flow

interface SiteDataSource {
    fun getAllSites(): Flow<List<SiteEntity>>
    suspend fun getSiteWithServices(siteId:Long): SiteWithService
    suspend fun insertAll(sites: List<SiteEntity>)
    suspend fun count(): Int
    suspend fun findFirst():SiteEntity?
    suspend fun insertCrossRef(ref: List<SiteServiceCrossRef>)
}