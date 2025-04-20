package edu.unicauca.lookapp.features.home.data.datasource

import edu.unicauca.lookapp.features.home.data.dao.ServiceDao
import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity

class RoomServiceLocalDataSourceImpl(private val serviceDao: ServiceDao):ServiceDataSource{
    override suspend fun insertAll(services: List<ServiceEntity>) {
        serviceDao.insertAll(services)
    }

    override suspend fun count(): Int {
        return serviceDao.count()
    }

}