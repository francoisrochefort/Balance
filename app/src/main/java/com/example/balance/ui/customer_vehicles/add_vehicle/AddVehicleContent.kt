package com.example.balance.ui.customer_vehicles.add_vehicle

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.vehicle.Vehicle

@Composable
fun AddVehicleContent(
    padding: PaddingValues,
    navigateToVehiclesScreen: () -> Unit,
    customerId: Int,
    viewModel: AddVehicleViewModel = hiltViewModel()
) {
    var model by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var plate by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = model,
            onValueChange = { text -> model = text },
            placeholder = {
                Text(
                    text = "Type a vehicle model..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = number,
            onValueChange = { text -> number = text },
            placeholder = {
                Text(
                    text = "Type the vehicle number..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = plate,
            onValueChange = { text -> plate = text },
            placeholder = {
                Text(
                    text = "Type the vehicle plate..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = capacity,
            onValueChange = { text -> capacity = text },
            placeholder = {
                Text(
                    text = "Type the capacity of the vehicle..."
                )
            }
        )
        Button(
            onClick = {
                val addVehicle = Vehicle(model, number, plate, capacity.toFloat(), customerId)
                viewModel.addVehicle(addVehicle)
                navigateToVehiclesScreen()
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}