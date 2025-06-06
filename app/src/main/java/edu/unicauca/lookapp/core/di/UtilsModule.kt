package edu.unicauca.lookapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.home.domain.usecases.LoadInitialServiceUseCase
import edu.unicauca.lookapp.features.home.domain.usecases.LoadInitialSiteUseCase
import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialSavedItemsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.LoadInitialUserAccountsUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {
    @Provides
    @Singleton
    fun provideSessionManager(saved: LoadInitialSavedItemsUseCase,
                              userAccount: LoadInitialUserAccountsUseCase,
                              site:LoadInitialSiteUseCase,
                              service:LoadInitialServiceUseCase
    ): SessionManager = SessionManager(
        loadInitialSavedItemsUseCase = saved,
        loadInitialUserAccountsUseCase = userAccount,
        loadInitialSiteUseCase=site,
        //loadInitialServiceUseCase=service


    )

}