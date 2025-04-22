package edu.unicauca.lookapp.features.home.data.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(
    //tableName = "site_service_cross_ref",
    primaryKeys =["siteId","serviceId"],
   /* indices=[
        Index(value= arrayOf("serviceId"))
    ]*/)
data class SiteServiceCrossRef (
    var siteId:Long=0L,
    var serviceId:Long=0L
)