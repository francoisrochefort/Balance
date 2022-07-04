package com.example.balance.ui.customer_vehicles.add_vehicle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.*
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun AddVehicleContent(
    padding: PaddingValues,
    navigateToVehiclesScreen: () -> Unit,
    customerId: Int,
    viewModel: AddVehicleViewModel = hiltViewModel()
) {
    MyForm {
        MyTextField(
            hint =  "Type a vehicle model...",
            label = "Model",
            value = viewModel.vehicle.model,
            onValueChange = { model -> viewModel.updateModel(model) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type a vehicle number...",
            label = "Number",
            value = viewModel.vehicle.number,
            onValueChange = { number -> viewModel.updateNumber(number) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type a vehicle plate...",
            label = "Number",
            value = viewModel.vehicle.plate,
            onValueChange = { plate -> viewModel.updatePlate(plate) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type a vehicle capacity...",
            label = "Capacity",
            value = viewModel.vehicle.capacity.toString(),
            onValueChange = { capacity -> viewModel.updateCapacity(capacity.toFloat()) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.NumberDone
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyButton(
            text = "Add",
            onClick = {
                viewModel.addVehicle(customerId)
                navigateToVehiclesScreen()
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}

