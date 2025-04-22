package edu.unicauca.lookapp.features.home.domain.usecases

import android.util.Log
import edu.unicauca.lookapp.features.home.data.repository.ServiceRepository
import edu.unicauca.lookapp.features.home.data.repository.SiteRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LoadInitialSiteUseCase @Inject constructor(
    private val siteRepository:SiteRepository,
    private val serviceRepository: ServiceRepository
) {
    suspend operator fun invoke(){
        /*
        val services=serviceRepository.getAll().first()
        Log.d("LoadInitialSiteUseCase","Services:$services")
        siteRepository.loadInitialData(services)**/
        siteRepository.loadInitialData()
    }
}