package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SiteWithService (
    @Embedded val site:SiteEntity,
    @Relation(
        parentColumn = "siteId",
        entityColumn = "serviceId",
        associateBy = Junction(SiteServiceCrossRef::class)
    )
    val services:List<ServiceEntity>
)