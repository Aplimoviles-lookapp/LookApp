package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef

class RoomSiteServiceCrossRefDataSourceImpl(private val siteDao: SiteDao):SiteServiceCrossRefDataSource {
    override suspend fun insertAll(relations: List<SiteServiceCrossRef>) {
       siteDao.insertSiteServiceCrossRefs(relations)
    }

}