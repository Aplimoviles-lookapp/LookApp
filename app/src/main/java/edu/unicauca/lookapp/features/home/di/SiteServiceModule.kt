package edu.unicauca.lookapp.features.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.home.data.dao.SiteDao
import edu.unicauca.lookapp.features.home.data.datasource.RoomSiteLocalDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.RoomSiteServiceCrossRefDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.SiteDataSource
import edu.unicauca.lookapp.features.home.data.datasource.SiteServiceCrossRefDataSource

@Module
@InstallIn(SingletonComponent::class)
class SiteServiceModule {
    @Provides
    fun provideSiteServicetLocalDataSource(
        siteDao: SiteDao
    ): SiteServiceCrossRefDataSource{

        return RoomSiteServiceCrossRefDataSourceImpl(siteDao)
    }
}