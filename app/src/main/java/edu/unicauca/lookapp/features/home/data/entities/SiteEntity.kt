package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sites")
data class SiteEntity (
    @PrimaryKey(autoGenerate = true)
    val siteId: Long = 0,
    val name:String,
    val address:String,
    val numberPhone:String
    )