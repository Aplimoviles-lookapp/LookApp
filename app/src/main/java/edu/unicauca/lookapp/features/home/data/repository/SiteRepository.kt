package edu.unicauca.lookapp.features.home.data.repository

import edu.unicauca.lookapp.features.home.data.datasource.ServiceDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteServiceCrossRefDataSource
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteWithService
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialServiceDataProvider
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialSiteDataProvider
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialSiteWithServiceDataProvider
import edu.unicauca.lookapp.features.saved.data.prepopulate.InitialSavedDataProvider
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


    suspend fun loadInitialData(){
        if(siteDataSource.count() > 0) return
        val site: List<SiteEntity> =InitialSiteDataProvider.sites
        siteDataSource.insertAll(site)



        /*
        siteDataSource.insertAll(InitialSiteDataProvider.sites)
        serviceDataSource.insertAll(InitialServiceDataProvider.services)
        crossRefDataSource.insertAll(InitialSiteWithServiceDataProvider.siteServiceRelations)
    */

    }

}