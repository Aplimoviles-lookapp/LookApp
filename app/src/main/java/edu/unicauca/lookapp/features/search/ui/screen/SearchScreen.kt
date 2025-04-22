package edu.unicauca.lookapp.features.search.ui.screen


import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import edu.unicauca.lookapp.features.search.ui.viewmodel.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val location by viewModel.location.collectAsState()
    val permissionGranted = remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted.value = isGranted
        if (isGranted) {
            viewModel.fetchLocation()
        }
    }

    LaunchedEffect(Unit) {
        val hasPermission = ActivityCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        permissionGranted.value = hasPermission
        if (hasPermission) {
            viewModel.fetchLocation()
        } else {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        MapView(
            location = location,
            permissionGranted = permissionGranted.value
        )
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            onSearchClick = {
                Toast.makeText(context, "Funcionalidad de búsqueda no disponible aún", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


