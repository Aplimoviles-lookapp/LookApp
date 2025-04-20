package edu.unicauca.lookapp.features.home.data.prepopulate

import edu.unicauca.lookapp.features.home.data.entities.ServiceEntity

object InitialServiceDataProvider {
    val services = listOf(
        ServiceEntity(name = "Corte de Cabello", description = "Corte clásico para dama o caballero"),
        ServiceEntity(name = "Peinado", description = "Peinados para toda ocasión"),
        ServiceEntity(name = "Tinte", description = "Coloración profesional"),
        ServiceEntity(name = "Shampoo", description = "Limpieza capilar profunda")
    )
}