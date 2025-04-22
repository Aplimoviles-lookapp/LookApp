package edu.unicauca.lookapp.features.notifications.domain.usecases

import edu.unicauca.lookapp.features.notifications.data.repository.NotificationRepository
import edu.unicauca.lookapp.features.notifications.domain.model.Notification
import edu.unicauca.lookapp.features.notifications.domain.mapper.toEntity
import javax.inject.Inject

class AddNotificationUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    suspend operator fun invoke(notification: Notification) {
        repository.insert(notification.toEntity())
    }
}