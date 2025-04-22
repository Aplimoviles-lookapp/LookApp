package edu.unicauca.lookapp.features.home.data.repository

import edu.unicauca.lookapp.features.home.data.datasource.ServiceDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteServiceCrossRefDataSource
import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef
import edu.unicauca.lookapp.features.home.data.entities.SiteWithService
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialServiceDataProvider
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialSiteDataProvider
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialSiteWithServiceDataProvider
import javax.inject.Inject

class SiteRepository @Inject constructor(
    private val siteDataSource:SiteDataSource,
    private val serviceDataSource: ServiceDataSource,
    private val crossRefDataSource: SiteServiceCrossRefDataSource
){
    suspend fun getSiteWithServices(siteId:Long): SiteWithService {
       return  siteDataSource.getSiteWithServices(siteId)
    }
    fun getAllSites()=siteDataSource.getAllSites()


    suspend fun loadInitialData(/*services:List<ServiceEntity>*/){
        if(siteDataSource.count() > 0) return
        siteDataSource.insertAll(InitialSiteDataProvider.sites)
        serviceDataSource.insertAll(InitialServiceDataProvider.services)
        crossRefDataSource.insertAll(InitialSiteWithServiceDataProvider.siteServiceRelations)
        /*
        val site: List<SiteEntity> =InitialSiteDataProvider.sites
        siteDataSource.insertAll(site)

        val  savedSite=siteDataSource.findFirst()

        if(savedSite!=null){
            siteDataSource.insertCrossRef(
                services.map { service ->
                    SiteServiceCrossRef(
                        siteId=savedSite.siteId,
                        serviceId = service.serviceId
                    )
                }
            )
        }
*/



    }

}