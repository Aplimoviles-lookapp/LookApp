package edu.unicauca.lookapp.features.saved.data.prepopulate

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity

object InitialSavedDataProvider {
    fun getItems(): List<ItemEntity> = listOf(
        ItemEntity(
            title = "Caroy Peluqueria",
            subtitle = "Corte de pelo",
            imageUrl = "https://picsum.photos/201",
        ),
        ItemEntity(
            title = "Peluqueria el calvo",
            subtitle = "Shampoo",
            imageUrl = "https://picsum.photos/201",
        ),
        ItemEntity(
            title = "Peluqueria el calvo",
            subtitle = "Corte de pelo",
            imageUrl = "https://picsum.photos/201",
        ),
        ItemEntity(
            title = "Salon de belleza",
            subtitle = "Corte de pelo",
            imageUrl = "https://picsum.photos/201",
        ),

    )
}