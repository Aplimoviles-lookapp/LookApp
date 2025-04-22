package edu.unicauca.lookapp.features.notifications.data.datasource

import edu.unicauca.lookapp.features.notifications.data.dao.NotificationDao
import edu.unicauca.lookapp.features.notifications.data.entities.NotificationEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomNotificationLocalDataSourceImpl @Inject constructor(
    private val dao: NotificationDao
) : NotificationDataSource {

    override suspend fun insert(notification: NotificationEntity) {
        dao.insert(notification)
    }

    override fun getAll(): Flow<List<NotificationEntity>> {
        return dao.getAll()
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun markAsRead(id: Long) {
        dao.markAsRead(id)
    }
}