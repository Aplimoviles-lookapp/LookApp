package edu.unicauca.lookapp.features.home.domain.usecases

import edu.unicauca.lookapp.features.home.data.repository.ServiceRepository
import javax.inject.Inject

class LoadInitialServiceUseCase @Inject constructor(private val serviceRepository: ServiceRepository) {
    suspend operator fun invoke(){
        serviceRepository.loadInitialData()
    }
}