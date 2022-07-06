package com.example.balance.ui.customers.add_customer

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.repo.customer.CustomerRepositoryImpl
import com.example.balance.ui.components.ObjectAlreadyExistExceptionAlertDialog

@Composable
fun AddCustomerScreen(
    navigateToCustomersScreen: () -> Unit,
    viewModel: AddCustomerViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        viewModel.event.collect { event ->
            when (event) {
                is AddCustomerEvent.OnError -> {
                    when (event.exception) {
                        is CustomerRepositoryImpl.CustomerAlreadyExists -> {
                            showDialog = true
                        }
                    }
                }
                is AddCustomerEvent.OnNew -> {
                    navigateToCustomersScreen()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            AddCustomerTopBar(navigateToCustomersScreen = navigateToCustomersScreen)
        },
        content = { padding ->
            AddCustomerContent(padding = padding)
        }
    )
    if (showDialog) {
        ObjectAlreadyExistExceptionAlertDialog(
            hideDialog = {
                showDialog = false
            },
            onReplace = {
                viewModel.addCustomer(true)
            }
        )
    }
}