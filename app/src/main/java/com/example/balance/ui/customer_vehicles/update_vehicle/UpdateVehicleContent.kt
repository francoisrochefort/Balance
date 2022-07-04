package com.example.balance.ui.customer_vehicles.update_vehicle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.MyButton
import com.example.balance.ui.components.MyForm
import com.example.balance.ui.components.MyTextField
import com.example.balance.ui.components.NumberDone
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun UpdateVehicleContent(
    padding: PaddingValues,
    id: Int,
    navigateToVehiclesScreen: () -> Unit,
    viewModel: UpdateVehicleViewModel = hiltViewModel()
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
            text = "Update",
            onClick = {
                viewModel.updateVehicle()
                navigateToVehiclesScreen()
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}