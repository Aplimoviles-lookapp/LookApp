package edu.unicauca.lookapp.features.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.home.data.dao.ShiftDao
import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.datasource.RoomShiftLocalDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.RoomSiteLocalDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.ShiftDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteDataSource

@Module
@InstallIn(SingletonComponent::class)
class SiteModule {
    @Provides
    fun provideSitetLocalDataSource(
        siteDao:SiteDao
    ):SiteDataSource {

        return RoomSiteLocalDataSourceImpl(siteDao)
    }
}