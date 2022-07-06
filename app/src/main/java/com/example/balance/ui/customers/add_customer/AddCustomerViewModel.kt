package com.example.balance.ui.customers.add_customer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.Routes
import com.example.balance.data.customer.Customer
import com.example.balance.repo.customer.CustomerRepository
import com.example.balance.ui.users.add_user.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

sealed class AddCustomerEvent {
    data class OnNew(val customer: Customer): AddCustomerEvent()
    data class OnError(val exception: Exception) : AddCustomerEvent()
}

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    var customer by mutableStateOf(Customer("", "", "", ""))
        private set

    private val _event = Channel<AddCustomerEvent>()
    val event = _event.receiveAsFlow()

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

    fun addCustomer(replace: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val id: Long = repo.addCustomerToRoom(
                    customer = customer,
                    replace = replace
                )
                _event.send(AddCustomerEvent.OnNew(customer.copy(
                    id = id.toInt()
                )))
            }
            catch (e: Exception) {
                _event.send(AddCustomerEvent.OnError(e))
            }
        }
    }
}







