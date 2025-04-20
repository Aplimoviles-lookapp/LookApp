package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteWithService
import kotlinx.coroutines.flow.Flow

class RoomSiteLocalDataSourceImpl (private val siteDao:SiteDao):SiteDataSource{
    override fun getAllSites(): Flow<List<SiteEntity>> {
        return siteDao.getAllSites()
    }

    override suspend fun getSiteWithServices(siteId: Long): SiteWithService {
        return siteDao.getSiteWithServices(siteId)
    }

    override suspend fun insertAll(sites: List<SiteEntity>) {
        siteDao.insertAll(sites)
    }

    override suspend fun count(): Int {
        return siteDao.count()
    }

}