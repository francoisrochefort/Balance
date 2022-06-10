package com.example.balance.ui.customers.add_customer

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

    fun addCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addCustomerToRoom(customer)
        }
    }
}