package edu.unicauca.lookapp.features.home.data.prepopulate

import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteEntity
import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef

object InitialSiteDataProvider {
    val sites = listOf(
        SiteEntity(name = "Peluquería Caro", address = "Calle 10 #5-20", numberPhone = "3121234567"),
        SiteEntity(name = "Barber Shop Ivan", address = "Carrera 7 #14-89", numberPhone = "3159876543"),
        SiteEntity(name = "Salon Marta", address = "Avenida 3N #8-55", numberPhone = "3001122334")
    )



}