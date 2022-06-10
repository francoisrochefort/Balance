package com.example.balance.ui.customers.update_customer

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
class UpdateCustomerViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    var customer by mutableStateOf(Customer("", "", "", ""))

    fun getCustomer(id: Int) {
        viewModelScope.launch {
            repo.getCustomerFromRoom(id).collect { response ->
                customer = response
            }
        }
    }

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

    fun updateCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateCustomerInRoom(customer)
        }
    }
}