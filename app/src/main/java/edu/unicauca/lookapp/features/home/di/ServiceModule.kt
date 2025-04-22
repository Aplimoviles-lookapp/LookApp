package edu.unicauca.lookapp.features.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.home.data.dao.ServiceDao
import edu.unicauca.lookapp.features.home.data.datasource.RoomServiceLocalDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.ServiceDataSource


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    fun provideServiceLocalDataSource(
        serviceDao: ServiceDao
    ): ServiceDataSource {

        return RoomServiceLocalDataSourceImpl(serviceDao)
    }
}

