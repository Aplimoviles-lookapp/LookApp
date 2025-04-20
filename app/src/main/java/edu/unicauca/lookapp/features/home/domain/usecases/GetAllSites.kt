package edu.unicauca.lookapp.features.home.domain.usecases

import edu.unicauca.lookapp.features.home.data.repository.SiteRepository
import javax.inject.Inject

class GetAllSites @Inject constructor(private val siteRepository: SiteRepository) {
    operator  fun invoke()=siteRepository.getAllSites()

}