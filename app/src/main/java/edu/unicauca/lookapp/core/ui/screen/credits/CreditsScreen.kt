package edu.unicauca.lookapp.core.ui.screen.credits


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CreditsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "LOOKAPP es una aplicación la cual los usuarios van a poder realizar " +
                    "la separación de turno para peluqueria o salon de belleza, además " +
                    "permitirá visualizar tipos de peinados, cortes de pelo, también el tipo " +
                    "y diseño de uñas de manos y pies. La aplicación también notificará " +
                    "promociones de artículos o de servicios y permitirá ver los lugares " +
                    "cercanos en un mapa",
            style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Justify),
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Esta app fue desarrollada por:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        CreditItem(name = "Jojan Serna", role = "Developer")
        CreditItem(name = "Freider Escobar", role = "Developer")
        CreditItem(name = "Brayan Majin", role = "Developer")


        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "App Version: 1.0.0",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}