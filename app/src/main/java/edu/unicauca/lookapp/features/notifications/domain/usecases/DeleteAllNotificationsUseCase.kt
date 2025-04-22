package edu.unicauca.lookapp.features.notifications.domain.usecases

import edu.unicauca.lookapp.features.notifications.data.repository.NotificationRepository
import javax.inject.Inject

class DeleteAllNotificationsUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    suspend operator fun invoke() {
        repository.deleteAll()
    }
}