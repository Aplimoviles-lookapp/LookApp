package edu.unicauca.lookapp.features.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.home.data.dao.ShiftDao
import edu.unicauca.lookapp.features.home.data.datasource.RoomShiftLocalDataSourceImpl
import edu.unicauca.lookapp.features.home.data.datasource.ShiftDataSource

@Module
@InstallIn(SingletonComponent::class)
class ShiftModule {
    @Provides
    fun provideShiftLocalDataSource(
        shiftDao:ShiftDao
    ):ShiftDataSource{
        return RoomShiftLocalDataSourceImpl(shiftDao)
    }
}