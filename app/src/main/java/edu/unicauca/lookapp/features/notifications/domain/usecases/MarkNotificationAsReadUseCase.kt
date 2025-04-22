package edu.unicauca.lookapp.features.notifications.domain.usecases

import edu.unicauca.lookapp.features.notifications.data.repository.NotificationRepository
import javax.inject.Inject

class MarkNotificationAsReadUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    suspend operator fun invoke(notificationId: Long) {
        repository.markAsRead(notificationId)
    }
}