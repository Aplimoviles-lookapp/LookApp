package edu.unicauca.lookapp.features.notifications.data.repository

import edu.unicauca.lookapp.features.notifications.data.datasource.NotificationDataSource
import edu.unicauca.lookapp.features.notifications.data.entities.NotificationEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationRepository @Inject constructor(
    private val dataSource: NotificationDataSource
) {
    suspend fun insert(notification: NotificationEntity) = dataSource.insert(notification)

    fun getAll(): Flow<List<NotificationEntity>> = dataSource.getAll()

    suspend fun deleteAll() = dataSource.deleteAll()

    suspend fun markAsRead(id: Long) = dataSource.markAsRead(id)

}