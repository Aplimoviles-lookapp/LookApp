package edu.unicauca.lookapp.features.home.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.unicauca.lookapp.features.home.ui.viewmodel.ShiftViewModel
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@Composable
fun Form(
    modifier: Modifier = Modifier,
    shiftViewModel: ShiftViewModel = hiltViewModel(),
     savedViewModel: SavedViewModel = hiltViewModel()


) {

   val shiftUiState=shiftViewModel.shiftUiState
    val sitios = shiftViewModel.sitios
    val servicios = shiftViewModel.servicios
    val sessionState by savedViewModel.sessionManager.uiState.collectAsState()
    val userName = sessionState.currentUserAccount?.name ?: ""
    if (shiftUiState.shiftDetails.nombre.isBlank() && userName.isNotBlank()) {
        shiftViewModel.updateNombre(userName)
    }


    Column(

        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)


    ) {

        TextField(

            value=shiftUiState.shiftDetails.nombre,
           // value = shiftUiState.shiftDetails.nombre,
            onValueChange = { shiftViewModel.updateNombre(it)},
            label = {
                Text(
                    text="Nombre y Apellido",
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall

                )
            },
            modifier = Modifier.fillMaxWidth()


        )

        Spacer(modifier = Modifier.height(8.dp))

        // DropDown de Negocios
        DropDownMenu(
            label = "Nombre del Negocio",
            options = sitios.map { it.name },
            selectedOption = shiftUiState.shiftDetails.negocio,
            onOptionSelected = { shiftViewModel.onSelectNegocio(it) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (shiftUiState.shiftDetails.negocio.isNotEmpty()) {
            DropDownMenu(
                label = "Servicio",
                options = servicios,
                selectedOption = shiftUiState.shiftDetails.servicio,
                onOptionSelected = { shiftViewModel.onSelectServicio(it) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))
        DatePickerFieldToModal(
            selectedDate = shiftUiState.shiftDetails.fecha,
            onDateSelected = { shiftViewModel.updateFecha(it) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        DropDownMenu(
            label = "Horario",
            options = listOf("9:00-10:00", "10:00-11:00", "11:00-1:00"),
            selectedOption = shiftUiState.shiftDetails.horario,
            onOptionSelected = { shiftViewModel.updateHorario(it) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            OutlinedButtonExample(onClick = {
                shiftViewModel.clearForm()
            })
            Spacer(modifier=Modifier.width(8.dp))
            FilledButtonExample(
                onClick = {
                    shiftViewModel.insertShift()
                    shiftViewModel.clearForm()
                    shiftViewModel.showDialog()
                }
            )
        }

    }
    if (shiftViewModel.showConfirmationDialog) {
        ConfirmationDialog(onDismiss = { shiftViewModel.dismissDialog() })
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select a Date") },
        text = {
            DatePicker(
                state = datePickerState,
                showModeToggle = false
            )
        },
        confirmButton = {
            Button(onClick = {
                datePickerState.selectedDateMillis?.let { onDateSelected(it) }
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
@Composable
fun DatePickerFieldToModal(
    selectedDate: Date?,
    onDateSelected: (Date) -> Unit,
    modifier: Modifier = Modifier
) {
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedDate?.let { convertDateToFormattedString(it) } ?: "",
        onValueChange = { },
        label = { Text("Fecha") },
        placeholder = { Text("DD/MM/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Selecciona Fecha")
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            .fillMaxWidth()
            .pointerInput(selectedDate)
            {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        DatePickerModal(
            onDateSelected = {
                onDateSelected(Date(it))
                showModal = false
            },
            onDismiss = { showModal = false }
        )
    }
}



fun convertDateToFormattedString(date: Date): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    return formatter.format(date)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            TextField(
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                value = selectedOption,
                onValueChange = {},
                readOnly = true,
                label = { Text(label,
                    style = MaterialTheme.typography.bodySmall
                    ) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onOptionSelected(option)
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Composable
fun FilledButtonExample(
    onClick:()->Unit
){
    Button(
        onClick=onClick
    ) {
        Text(text="Agendar")
    }

}
@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Text(text = "Cancelar")
    }
}
@Composable
fun ConfirmationDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Cita Agendada") },
        text = { Text("Tu cita ha sido agendada exitosamente.") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Aceptar")
            }
        }
    )
}

@Preview
@Composable
fun FormPreview(){
    Form(

    )

}