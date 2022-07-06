package com.example.balance.ui.customers.update_customer

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.repo.customer.CustomerRepositoryImpl
import com.example.balance.ui.components.ObjectAlreadyExistExceptionAlertDialog

@Composable
fun UpdateCustomerScreen(
    id: Int,
    navigateToCustomersScreen: () -> Unit,
    viewModel: UpdateCustomerViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        viewModel.getCustomer(id)
        viewModel.event.collect { event ->
            when (event) {
                is UpdateCustomerEvent.OnError -> {
                    when (event.exception) {
                        is CustomerRepositoryImpl.CustomerAlreadyExists -> {
                            showDialog = true
                        }
                    }
                }
                is UpdateCustomerEvent.OnUpdate -> {
                    navigateToCustomersScreen()
                }
            }
        }
    }
    Scaffold(
        topBar = {
            UpdateCustomerTopBar(
                navigateToCustomersScreen = navigateToCustomersScreen
            )
        },
        content = { padding ->
            UpdateCustomerContent(
                padding = padding,
            )
        }
    )
    if (showDialog) {
        ObjectAlreadyExistExceptionAlertDialog(
            hideDialog = {
                showDialog = false
            },
            onReplace = {
                viewModel.updateCustomer(true)
            }
        )
    }
}