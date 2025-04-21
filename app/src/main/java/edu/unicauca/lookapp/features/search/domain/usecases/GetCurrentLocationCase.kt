package edu.unicauca.lookapp.features.search.domain.usecases

import android.location.Location
import edu.unicauca.lookapp.features.search.domain.repository.LocationRepository

class GetCurrentLocationCase(private val locationRepository: LocationRepository)
{
    suspend operator fun invoke(): Location? {
        return locationRepository.getCurrentLocation()
    }
}