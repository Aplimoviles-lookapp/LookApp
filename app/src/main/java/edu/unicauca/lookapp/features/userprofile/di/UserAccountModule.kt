package edu.unicauca.lookapp.features.userprofile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.userprofile.data.dao.UserAccountDao
import edu.unicauca.lookapp.features.userprofile.data.datasource.RoomUserAccountLocalDataSourceImpl
import edu.unicauca.lookapp.features.userprofile.data.datasource.UserAccountDataSource

@Module
@InstallIn(SingletonComponent::class)
class UserAccountModule {
    @Provides
    fun providesUserAccountLocalDataSource(
        userAccountDao: UserAccountDao
    ): UserAccountDataSource {
        return RoomUserAccountLocalDataSourceImpl(userAccountDao)
    }
}