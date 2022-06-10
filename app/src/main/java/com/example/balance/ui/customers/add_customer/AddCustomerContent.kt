package com.example.balance.ui.customers.add_customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.customer.Customer

@Composable
fun AddCustomerContent(
    padding: PaddingValues,
    navigateToCustomersScreen: () -> Unit,
    viewModel: AddCustomerViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { text -> name = text },
            placeholder = {
                Text(
                    text = "Type a customer name..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = address,
            onValueChange = { text -> address = text },
            placeholder = {
                Text(
                    text = "Type the customer address..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = city,
            onValueChange = { text -> city = text },
            placeholder = {
                Text(
                    text = "Type the city..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = contact,
            onValueChange = { text -> contact = text },
            placeholder = {
                Text(
                    text = "Type the name of the contact..."
                )
            }
        )
        Button(
            onClick = {
                val addCustomer = Customer(name, address, city, contact)
                viewModel.addCustomer(addCustomer)
                navigateToCustomersScreen()
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}