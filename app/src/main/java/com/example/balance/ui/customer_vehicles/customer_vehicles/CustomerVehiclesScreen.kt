package com.example.balance.ui.customer_vehicles.customer_vehicles

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.list.ListScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomerVehiclesScreen(
    navigateToAddCustomerVehicleScreen: (customerId: Int) -> Unit,
    navigateToUpdateCustomerVehicleScreen: (id: Int) -> Unit,
    customerId: Int,
    viewModel: CustomerVehiclesViewModel = hiltViewModel()
) {
    ListScreen(
        title = "Customer Vehicles",
        navigateToAddItemScreen = {
            navigateToAddCustomerVehicleScreen(customerId)
        },
        navigateToUpdateItemScreen = { id ->
            navigateToUpdateCustomerVehicleScreen(id)
        },
        fetchList = {
            viewModel.getVehicles(customerId)
        },
        getList = {
            viewModel.vehicles
        },
        getSearch = {
            viewModel.search
        },
        search = { text ->
            viewModel.getSearch(customerId, text)
        },
        getItemId = {
            it.id
        },
        getItemText = {
            it.model
        },
        deleteItem = {
            viewModel.deleteVehicle(it)
        },
        colors = listOf(
            Color(0xFF2F8DFD),
            Color(0xFF042058)
        )
    )
}