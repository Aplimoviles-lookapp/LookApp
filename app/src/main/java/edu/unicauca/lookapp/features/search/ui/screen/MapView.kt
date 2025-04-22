package edu.unicauca.lookapp.features.search.ui.screen


import android.location.Location
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapView(
    location: Location?,
    permissionGranted: Boolean,
    modifier: Modifier = Modifier
) {
    val defaultLatLng = LatLng(2.444814, -76.614739)
    val currentLatLng = location?.let { LatLng(it.latitude, it.longitude) } ?: defaultLatLng

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLatLng, 14f)
    }
    val markerState = remember { MarkerState(position = currentLatLng) }

    val beautyPlaces = remember {
        listOf(
            BeautyPlace("Peluquería Estilo", LatLng(2.446214, -76.612539), "Peluquería"),
            BeautyPlace("Barbería Moderna", LatLng(2.442814, -76.615739), "Barbería"),
            BeautyPlace("Salón de Belleza Glamour", LatLng(2.448814, -76.613739), "Salón de Belleza"),
            BeautyPlace("Cortes & Estilos", LatLng(2.443814, -76.617739), "Peluquería"),
            BeautyPlace("Barbería Clásica", LatLng(2.447814, -76.611739), "Barbería")
        )
    }

    LaunchedEffect(location) {
        if (location != null) {
            cameraPositionState.animate(
                CameraUpdateFactory.newLatLngZoom(currentLatLng, 17f)
            )
            markerState.position = currentLatLng
        }
    }
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        if (permissionGranted && location != null){
            Marker(
                state = markerState,
                title = "Tu ubicación",
                snippet = "Aquí estás"
            )
        }
        beautyPlaces.forEach { place ->
            Marker(
                state = MarkerState(position = place.position),
                title = place.name,
                snippet = place.type,
                icon = when (place.type) {
                    "Peluquería" -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                    "Barbería" -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                    else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                }
            )
        }
    }
}
