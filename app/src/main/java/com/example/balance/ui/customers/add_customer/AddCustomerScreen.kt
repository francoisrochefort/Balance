package com.example.balance.ui.customers.add_customer

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun AddCustomerScreen(
    navigateToCustomersScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            AddCustomerTopBar(
                navigateToCustomersScreen = navigateToCustomersScreen
            )
        },
        content = { padding ->
            AddCustomerContent(
                padding = padding,
                navigateToCustomersScreen = navigateToCustomersScreen
            )
        }
    )
}