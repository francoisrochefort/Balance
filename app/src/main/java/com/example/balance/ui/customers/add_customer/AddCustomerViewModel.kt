package com.example.balance.ui.customers.add_customer

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.customer.Customer
import com.example.balance.repo.customer.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    var customer by mutableStateOf(Customer("", "", "", ""))
        private set
    var exception by mutableStateOf<Exception?>(null)

    fun updateName(name: String) {
        customer = customer.copy(name = name)
    }

    fun updateAddress(address: String) {
        customer = customer.copy(address = address)
    }

    fun updateCity(city: String) {
        customer = customer.copy(city = city)
    }

    fun updateContact(contact: String) {
        customer = customer.copy(contact = contact)
    }

    fun addCustomer() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.addCustomerToRoom(customer)
            }
            catch (e: Exception) {
                exception = e
            }
        }
    }
}