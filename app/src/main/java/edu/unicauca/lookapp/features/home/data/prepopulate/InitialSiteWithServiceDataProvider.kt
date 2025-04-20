package edu.unicauca.lookapp.features.home.data.prepopulate

import edu.unicauca.lookapp.features.home.data.entities.SiteServiceCrossRef

object InitialSiteWithServiceDataProvider {
    val siteServiceRelations = listOf(
        SiteServiceCrossRef(siteId = 1, serviceId = 1),
        SiteServiceCrossRef(siteId = 1, serviceId = 2),
        SiteServiceCrossRef(siteId = 2, serviceId = 1),
        SiteServiceCrossRef(siteId = 2, serviceId = 4),
        SiteServiceCrossRef(siteId = 3, serviceId = 3)
    )
}