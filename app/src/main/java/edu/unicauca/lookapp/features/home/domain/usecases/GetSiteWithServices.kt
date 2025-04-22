package edu.unicauca.lookapp.features.home.domain.usecases

import edu.unicauca.lookapp.features.home.data.repository.SiteRepository
import javax.inject.Inject

class GetSiteWithServices @Inject constructor(private val siteRepository: SiteRepository) {
    suspend operator fun invoke(siteId:Long)=siteRepository.getSiteWithServices(siteId)

}