package com.example.balance.ui.customers.customers

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
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    var customers by mutableStateOf(emptyList<Customer>())
    var search by mutableStateOf(emptyList<Customer>())

    fun getCustomers() {
        viewModelScope.launch {
            repo.getCustomersFromRoom().collect { response ->
                customers = response
            }
        }
    }

    fun getSearch(text: String) {
        viewModelScope.launch {
            repo.getSearchFromRoom(text).collect { response ->
                search = response
            }
        }
    }

    fun deleteCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteCustomerFromRoom(customer)
        }
    }
}