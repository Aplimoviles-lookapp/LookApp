package edu.unicauca.lookapp.features.search.ui.screen

import com.google.android.gms.maps.model.LatLng

data class BeautyPlace(
    val name: String,
    val position: LatLng,
    val type: String
)