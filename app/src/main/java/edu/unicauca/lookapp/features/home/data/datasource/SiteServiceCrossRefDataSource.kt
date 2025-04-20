package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef
import javax.inject.Inject

interface  SiteServiceCrossRefDataSource  {
    suspend fun insertAll(relations: List<SiteServiceCrossRef>)
}