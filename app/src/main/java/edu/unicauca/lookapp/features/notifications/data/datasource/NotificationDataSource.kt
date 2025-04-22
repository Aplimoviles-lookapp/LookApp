package edu.unicauca.lookapp.features.notifications.data.datasource

import edu.unicauca.lookapp.features.notifications.data.entities.NotificationEntity
import kotlinx.coroutines.flow.Flow

interface NotificationDataSource {
    suspend fun insert(notification: NotificationEntity)
    fun getAll(): Flow<List<NotificationEntity>>
    suspend fun deleteAll()
    suspend fun markAsRead(id: Long)
}