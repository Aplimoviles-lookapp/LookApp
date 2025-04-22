package edu.unicauca.lookapp.features.notifications.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.unicauca.lookapp.features.notifications.data.datasource.NotificationDataSource
import edu.unicauca.lookapp.features.notifications.data.datasource.RoomNotificationLocalDataSourceImpl
import edu.unicauca.lookapp.features.notifications.data.dao.NotificationDao
import edu.unicauca.lookapp.features.notifications.data.repository.NotificationRepository
import edu.unicauca.lookapp.features.notifications.domain.usecases.AddNotificationUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.DeleteAllNotificationsUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.GetNotificationsUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.MarkNotificationAsReadUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationDataSource(
        dao: NotificationDao
    ): NotificationDataSource = RoomNotificationLocalDataSourceImpl(dao)

    @Provides
    @Singleton
    fun provideNotificationRepository(
        dataSource: NotificationDataSource
    ): NotificationRepository = NotificationRepository(dataSource)

    @Provides
    fun provideGetNotificationsUseCase(
        repository: NotificationRepository
    ) = GetNotificationsUseCase(repository)

    @Provides
    fun provideAddNotificationUseCase(
        repository: NotificationRepository
    ) = AddNotificationUseCase(repository)

    @Provides
    fun provideMarkNotificationAsReadUseCase(
        repository: NotificationRepository
    ) = MarkNotificationAsReadUseCase(repository)

    @Provides
    fun provideDeleteAllNotificationsUseCase(
        repository: NotificationRepository
    ) = DeleteAllNotificationsUseCase(repository)

}