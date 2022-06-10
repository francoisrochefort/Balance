package com.example.balance.ui.customers.update_customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.customer.Customer

@Composable
fun UpdateCustomerContent(
    padding: PaddingValues,
    id: Int,
    navigateToCustomersScreen: () -> Unit,
    viewModel: UpdateCustomerViewModel = hiltViewModel()
) {
    val name = viewModel.customer.name
    val address = viewModel.customer.address
    val city = viewModel.customer.city
    val contact = viewModel.customer.contact

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name -> viewModel.updateName(name) },
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
            value = address ?: "",
            onValueChange = { address -> viewModel.updateAddress(address) },
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
            value = city ?: "",
            onValueChange = { city -> viewModel.updateCity(city) },
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
            value = contact ?: "",
            onValueChange = { contact -> viewModel.updateContact(contact) },
            placeholder = {
                Text(
                    text = "Type the name of the contact..."
                )
            }
        )
        Button(
            onClick = {
                val updatedCustomer = Customer(name, address, city, contact, id)
                viewModel.updateCustomer(updatedCustomer)
                navigateToCustomersScreen()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}