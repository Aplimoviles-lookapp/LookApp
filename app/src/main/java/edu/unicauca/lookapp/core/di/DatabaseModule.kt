package edu.unicauca.lookapp.core.di

import androidx.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.core.data.database.LookAppDatabase
import edu.unicauca.lookapp.core.utils.SessionManager
import edu.unicauca.lookapp.features.saved.domain.usecases.LoadInitialSavedItemsUseCase
import edu.unicauca.lookapp.features.userprofile.domain.usecases.LoadInitialUserAccountsUseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LookAppDatabase {
        return Room.databaseBuilder(context, LookAppDatabase::class.java, "lookapp_database.db")
            .fallbackToDestructiveMigration(true)
            .build()
    }



    @Provides
    fun provideSavedDao(database: LookAppDatabase) = database.savedDao()

    @Provides
    fun provideUserAccountDao(database: LookAppDatabase) = database.userAccountDao()

    @Provides
    fun provideShiftDao(database:LookAppDatabase)=database.shiftDao()
}