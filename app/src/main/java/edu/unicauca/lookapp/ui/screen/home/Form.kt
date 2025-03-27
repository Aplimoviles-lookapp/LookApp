package edu.unicauca.lookapp.ui.screen.home


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
import androidx.compose.material.icons.materialIcon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




@Composable
fun Form(
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var servicio by remember { mutableStateOf("") }
    var negocio by remember { mutableStateOf("") }
    //var fecha by remember { mutableStateOf("") }

    Column(

        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {

        TextField(

            value = nombre,
            onValueChange = { nombre = it },
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
            value = servicio,
            onValueChange = { servicio = it },
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
            value = negocio,
            onValueChange = { negocio = it },
            label = {
                Text(text="Nombre del Negocio",
                    modifier=Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall

                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        //Spacer(modifier = Modifier.height(8.dp))
        //DatePickerDocked()
        Spacer(modifier = Modifier.height(8.dp))
        DatePickerFieldToModal()
        Spacer(modifier = Modifier.height(8.dp))
        DropDownMenu()
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            OutlinedButtonExample(onClick = {})
            Spacer(modifier=Modifier.width(8.dp))
            FilledButtonExample(onClick = {})
        }

    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

*/
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
fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedDate?.let { convertMillisToDate(it) } ?: "",
        onValueChange = { },
        label = { Text("Fecha") },
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select date")
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(selectedDate) {
                awaitEachGesture {
                    // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
                    // in the Initial pass to observe events before the text field consumes them
                    // in the Main pass.
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
            onDateSelected = { selectedDate = it },
            onDismiss = { showModal = false }
        )
    }
}



fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

//Drop down menu
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(){
    val list= listOf("9:00-10:00","10:00-11:00", "11:00")
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember{ mutableStateOf(list[0])}

    Column (
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ExposedDropdownMenuBox(
            expanded =isExpanded ,
            onExpandedChange ={isExpanded=!isExpanded}
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value =selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}


            )
            ExposedDropdownMenu(
                expanded = isExpanded, onDismissRequest = {isExpanded=false}
            ) {
                list.forEachIndexed{index,text->
                DropdownMenuItem(
                    text={Text(text=text)},
                    onClick = {
                        selectedText=list[index]
                        isExpanded=false
                    },
                    contentPadding =ExposedDropdownMenuDefaults.ItemContentPadding

                )}
            }

        }
        //Text(text="Current selected$selectedText")
    }
}

@Composable
fun FilledButtonExample(
    onClick:()->Unit
){
    Button(
        onClick={onClick()}
    ) {
        Text(text="Agendar")
    }

}
@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text(text = "Cancelar")
    }
}
@Preview
@Composable
fun FormPreview(){
    Form()
}