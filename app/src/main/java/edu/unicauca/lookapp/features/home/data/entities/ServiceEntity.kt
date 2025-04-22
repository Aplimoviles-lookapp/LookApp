package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class ServiceEntity (
    @PrimaryKey(autoGenerate = true)
    val serviceId: Long = 0,
    val name:String,
    val description:String

)