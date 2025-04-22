package edu.unicauca.lookapp.features.notifications.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.unicauca.lookapp.features.notifications.domain.model.Notification
import edu.unicauca.lookapp.features.notifications.domain.usecases.AddNotificationUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.DeleteAllNotificationsUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.GetNotificationsUseCase
import edu.unicauca.lookapp.features.notifications.domain.usecases.MarkNotificationAsReadUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val getNotificationsUseCase: GetNotificationsUseCase,
    private val addNotificationUseCase: AddNotificationUseCase,
    private val deleteAllNotificationsUseCase: DeleteAllNotificationsUseCase,
    private val markNotificationAsReadUseCase: MarkNotificationAsReadUseCase
) : ViewModel() {

    val notifications: StateFlow<List<Notification>> = getNotificationsUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addNotification(notification: Notification) {
        viewModelScope.launch {
            addNotificationUseCase(notification)
        }
    }

    fun markAsRead(notificationId: Long) {
        viewModelScope.launch {
            markNotificationAsReadUseCase(notificationId)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            deleteAllNotificationsUseCase()
        }
    }

    fun createFakeNotifications() {
        val now = System.currentTimeMillis()
        val yesterday = now - 86_400_000L
        val twoDaysAgo = now - (2 * 86_400_000L)

        val sampleNotifications = listOf(
            Notification(
                id = 1,
                title = "Bienvenido a LookApp",
                message = "Gracias por instalar la aplicación.",
                timestamp = now,
                isRead = false
            ),
            Notification(
                id = 2,
                title = "¿Sabías esto?",
                message = "Puedes guardar tus peluquerías favoritas.",
                timestamp = yesterday,
                isRead = false
            ),
            Notification(
                id = 3,
                title = "¿Sabías esto?",
                message = "Puedes guardar encontrar tus peluquerías favoritas.",
                timestamp = twoDaysAgo,
                isRead = false
            )
        )

        viewModelScope.launch {
            sampleNotifications.forEach { addNotificationUseCase(it) }
        }
    }
}