package edu.unicauca.lookapp.features.notifications.domain.model

data class Notification(
    val id: Long,
    val title: String,
    val message: String,
    val timestamp: Long,
    val isRead: Boolean
)