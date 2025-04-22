package edu.unicauca.lookapp.features.notifications.domain.usecases

import edu.unicauca.lookapp.features.notifications.data.repository.NotificationRepository
import edu.unicauca.lookapp.features.notifications.domain.mapper.toDomain
import edu.unicauca.lookapp.features.notifications.domain.model.Notification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNotificationsUseCase @Inject constructor(
    private val repository: NotificationRepository
) {
    operator fun invoke(): Flow<List<Notification>> {
        return repository.getAll().map { list -> list.map { it.toDomain() } }
    }
}