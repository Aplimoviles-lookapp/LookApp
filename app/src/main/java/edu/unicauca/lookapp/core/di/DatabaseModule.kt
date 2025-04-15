package edu.unicauca.lookapp.core.di

import androidx.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.core.data.database.LookAppDatabase
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
            .build()
    }



    @Provides
    fun provideSavedDao(database: LookAppDatabase) = database.savedDao()
}