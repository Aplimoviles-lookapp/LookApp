package edu.unicauca.lookapp.features.search.ui.screen


import android.location.Location
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapView(
    location: Location?,
    modifier: Modifier = Modifier
) {
    val defaultLatLng = LatLng(2.444814, -76.614739)
    val currentLatLng = location?.let { LatLng(it.latitude, it.longitude) } ?: defaultLatLng

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLatLng, 14f)
    }
    val markerState = remember { MarkerState(position = currentLatLng) }

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
        Marker(
            state = markerState,
            title = "Tu ubicación",
            snippet = "Aquí estás"
        )
    }
}
