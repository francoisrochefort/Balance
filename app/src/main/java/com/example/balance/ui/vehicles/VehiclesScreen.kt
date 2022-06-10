package com.example.balance.ui.vehicles

import com.example.balance.ui.customers.customers.CustomersViewModel
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.list.ListScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VehiclesScreen(
    navigateToAddCustomerScreen: () -> Unit,
    navigateToCustomerVehiclesScreen: (id: Int) -> Unit,
    viewModel: CustomersViewModel = hiltViewModel()
) {
    ListScreen(
        title = "Choose customer",
        navigateToAddItemScreen = navigateToAddCustomerScreen,
        navigateToUpdateItemScreen = navigateToCustomerVehiclesScreen,
        fetchList = {
            viewModel.getCustomers()
        },
        getList = {
            viewModel.customers
        },
        getSearch = {
            viewModel.search
        },
        search = { text ->
            viewModel.getSearch(text)
        },
        getItemId = {
            it.id
        },
        getItemText = {
            it.name
        },
        deleteItem = {
            viewModel.deleteCustomer(it)
        }
    )
}