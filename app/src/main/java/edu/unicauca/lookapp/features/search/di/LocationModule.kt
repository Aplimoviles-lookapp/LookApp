package edu.unicauca.lookapp.features.search.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.search.data.repository.LocationRepositoryImpl
import edu.unicauca.lookapp.features.search.domain.repository.LocationRepository
import edu.unicauca.lookapp.features.search.domain.usecases.GetCurrentLocationCase

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Provides
    fun provideFusedLocationClient(
        @ApplicationContext context: Context
    ): FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    @Provides
    fun provideLocationRepository(
        @ApplicationContext context: Context,
        fusedLocationProviderClient: FusedLocationProviderClient
    ): LocationRepository = LocationRepositoryImpl(context, fusedLocationProviderClient)

    @Provides
    fun provideGetCurrentLocationUseCase(
        repository: LocationRepository
    ): GetCurrentLocationCase = GetCurrentLocationCase(repository)

}