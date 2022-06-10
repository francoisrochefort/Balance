package com.example.balance.ui.customers.update_customer

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UpdateCustomerScreen(
    id: Int,
    navigateToCustomersScreen: () -> Unit,
    viewModel: UpdateCustomerViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getCustomer(id)
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
                id = id,
                navigateToCustomersScreen = navigateToCustomersScreen
            )
        }
    )
}