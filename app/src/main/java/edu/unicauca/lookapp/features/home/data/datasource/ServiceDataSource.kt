package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity
import kotlinx.coroutines.flow.Flow

interface ServiceDataSource {
    suspend fun insertAll(services: List<ServiceEntity>)
    suspend fun count(): Int
    suspend fun getAll(): Flow<List<ServiceEntity>>
}