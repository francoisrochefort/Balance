package com.example.balance.ui.customers.add_customer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.MyButton
import com.example.balance.ui.components.MyForm
import com.example.balance.ui.components.MyTextField
import com.example.balance.ui.components.TextDone
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun AddCustomerContent(
    padding: PaddingValues,
    //navigateToCustomersScreen: () -> Unit,
    viewModel: AddCustomerViewModel = hiltViewModel()
) {
    MyForm {
        MyTextField(
            hint =  "Type a customer name...",
            label = "Name",
            value = viewModel.customer.name,
            onValueChange = { name ->
                viewModel.updateName(name)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type the customer address...",
            label = "Address",
            value =  viewModel.customer.address ?: "",
            onValueChange = { address ->
                viewModel.updateAddress(address)
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false,
            maxLines = 3
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type the customer city...",
            label = "City",
            value = viewModel.customer.city ?: "",
            onValueChange = { city -> viewModel.updateCity(city) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type the name of the contact...",
            label = "Contact",
            value = viewModel.customer.contact ?: "",
            onValueChange = { contact -> viewModel.updateContact(contact) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.TextDone
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyButton(
            text = "Add",
            onClick = {
                viewModel.addCustomer()
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}