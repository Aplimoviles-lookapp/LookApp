package edu.unicauca.lookapp.features.home.data.repository

import edu.unicauca.lookapp.features.home.data.datasource.ServiceDataSource
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialServiceDataProvider
import edu.unicauca.lookapp.features.home.data.prepopulate.InitialSiteDataProvider
import javax.inject.Inject

class ServiceRepository @Inject constructor(private val serviceDataSource: ServiceDataSource){


    suspend fun loadInitialData(){
        if(serviceDataSource.count() > 0) return
        serviceDataSource.insertAll(InitialServiceDataProvider.services)
    }

    suspend fun getAll()= serviceDataSource.getAll()
}