package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Entity

@Entity(primaryKeys =["siteId","serviceId"])
data class SiteServiceCrossRef (
    val siteId:Long,
    val serviceId:Long
)