package com.example.balance.ui.customer_vehicles.update_vehicle

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UpdateVehicleContent(
    padding: PaddingValues,
    id: Int,
    navigateToVehiclesScreen: () -> Unit,
    viewModel: UpdateVehicleViewModel = hiltViewModel()
) {
    val model = viewModel.vehicle.model
    val number = viewModel.vehicle.number
    val plate = viewModel.vehicle.plate
    val capacity = viewModel.vehicle.capacity

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = model,
            onValueChange = { model -> viewModel.updateModel(model) },
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
            onValueChange = { number -> viewModel.updateNumber(number) },
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
            onValueChange = { plate -> viewModel.updatePlate(plate) },
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
            value = capacity.toString(),
            onValueChange = { capacity -> viewModel.updateCapacity(capacity.toFloat()) },
            placeholder = {
                Text(
                    text = "Type the capacity of the vehicle..."
                )
            }
        )
        Button(
            onClick = {
                //val updatedVehicle = Vehicle(model, number, plate, capacity, id, id)
                viewModel.updateVehicle(/*updatedVehicle*/)
                navigateToVehiclesScreen()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}