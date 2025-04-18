package edu.unicauca.lookapp.features.saved.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.saved.data.dao.SavedDao
import edu.unicauca.lookapp.features.saved.data.datasource.RoomSavedLocalDataSourceImpl
import edu.unicauca.lookapp.features.saved.data.datasource.SavedDataSource


@Module
@InstallIn(SingletonComponent::class)
class SavedModule {

    @Provides
    fun provideSavedLocalDataSource(
        savedDao: SavedDao
    ): SavedDataSource {
        return RoomSavedLocalDataSourceImpl(savedDao)
    }
}