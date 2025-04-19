package edu.unicauca.lookapp.features.home.ui.screen


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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.unicauca.lookapp.features.home.ui.viewmodel.ShiftViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



@Composable
fun Form(
    modifier: Modifier = Modifier,
    shiftViewModel: ShiftViewModel = hiltViewModel(),
) {

   val shiftUiState=shiftViewModel.shiftUiState
    Column(

        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {

        TextField(

            value = shiftUiState.shiftDetails.nombre,
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

        TextField(
            value = shiftUiState.shiftDetails.servicio,
            onValueChange = {shiftViewModel.updateServicio(it)},
            label = {
                Text(
                    text="Servicio" ,
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall

                )

            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = shiftUiState.shiftDetails.negocio,
            onValueChange = { shiftViewModel.updateNegocio(it)},
            label = {
                Text(text="Nombre del Negocio",
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall

                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        DatePickerFieldToModal(
            selectedDate = shiftUiState.shiftDetails.fecha,
            onDateSelected = { shiftViewModel.updateFecha(it) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        DropDownMenu(
            selectedOption = shiftUiState.shiftDetails.horario,
            onOptionSelected = {shiftViewModel.updateHorario(it) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            OutlinedButtonExample(onClick = {})
            Spacer(modifier=Modifier.width(8.dp))
            FilledButtonExample(
                onClick = {
                    shiftViewModel.insertShift()
                    shiftViewModel.clearForm()
                }
            )
        }

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

fun formatDateToString(date: Date): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(date)
}
@Composable
fun DatePickerFieldToModal(
    selectedDate: Date?,
    onDateSelected: (Date) -> Unit
) {
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedDate?.let { formatDateToString(it) } ?: "",
        onValueChange = { },
        label = { Text("Fecha") },
        placeholder = { Text("DD/MM/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select date")
        },
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) showModal = true
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




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val list = listOf("9:00-10:00", "10:00-11:00", "11:00-1:00")
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            TextField(
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                value = selectedOption,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text("Seleccione una opción") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                list.forEach { text ->
                    DropdownMenuItem(
                        text = { Text(text) },
                        onClick = {
                            onOptionSelected(text)
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
@Preview
@Composable
fun FormPreview(){
    Form(

    )

}