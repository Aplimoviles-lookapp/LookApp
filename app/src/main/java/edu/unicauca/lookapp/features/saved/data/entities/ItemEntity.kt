package edu.unicauca.lookapp.features.saved.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity (
    @PrimaryKey(autoGenerate = true)
    val itemId: Long = 0,
    val title: String,
    val subtitle: String,
    val imageUrl: String,
)