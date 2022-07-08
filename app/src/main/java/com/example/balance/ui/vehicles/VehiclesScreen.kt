package com.example.balance.ui.vehicles

import android.content.Context
import com.example.balance.ui.customers.customers.CustomersViewModel
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.R
import com.example.balance.ui.components.list.ListScreen
import com.example.balance.ui.theme.MyVehicleMenuColor1
import com.example.balance.ui.theme.MyVehicleMenuColor2

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VehiclesScreen(
    navigateToAddCustomerScreen: () -> Unit,
    navigateToCustomerVehiclesScreen: (id: Int) -> Unit,
    viewModel: CustomersViewModel = hiltViewModel()
) {
    val context: Context = LocalContext.current
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
        },
        colors = listOf(
            MyVehicleMenuColor1,
            MyVehicleMenuColor2
        ),
        getEventFlow = {
            viewModel.event
        },
        getSnackBarMessage = {
            context.getString(R.string.customer_deleted)
        },
        undoDelete = {
            viewModel.undoDelete()
        }
    )
}