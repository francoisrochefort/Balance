package com.example.balance.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.customer.Customer
import com.example.balance.data.material.Material
import com.example.balance.data.user.User
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.repo.customer.CustomerRepository
import com.example.balance.repo.material.MaterialRepository
import com.example.balance.repo.user.UserRepository
import com.example.balance.repo.vehicle.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val customerRepository: CustomerRepository,
    private val vehicleRepository: VehicleRepository,
    private val materialRepository: MaterialRepository
) : ViewModel() {

    var users by mutableStateOf(emptyList<User>())
        private set
    var customers by mutableStateOf(emptyList<Customer>())
        private set
    var vehicles by mutableStateOf(emptyList<Vehicle>())
        private set
    var materials by mutableStateOf(emptyList<Material>())
        private set

    var selectedUser: User? by mutableStateOf(null)
        private set
    var selectedCustomer: Customer? by mutableStateOf(null)
        private set
    var selectedVehicle: Vehicle? by mutableStateOf(null)
        private set
    var selectedMaterial: Material? by mutableStateOf(null)
        private set

    fun getUsers() {
        viewModelScope.launch {
            userRepository.getUsersFromRoom().collect { response ->
                users = response
            }
        }
    }
    fun getCustomers() {
        viewModelScope.launch {
            customerRepository.getCustomersFromRoom().collect { response ->
                customers = response
            }
        }
    }
    private fun getVehicles() {
        viewModelScope.launch {
            vehicleRepository.getVehiclesFromRoom(selectedCustomer!!.id).collect { response ->
                vehicles = response
            }
        }
    }
    fun getMaterials() {
        viewModelScope.launch {
            materialRepository.getMaterialsFromRoom().collect { response ->
                materials = response
            }
        }
    }

    fun selectUser(user: User) {
        selectedUser = user
    }
    fun selectCustomer(customer: Customer) {
        if (customer != selectedCustomer) {
            selectedVehicle = null
            selectedCustomer = customer
            getVehicles()
        }
    }
    fun selectVehicle(vehicle: Vehicle) {
        selectedVehicle = vehicle
    }
    fun selectMaterial(material: Material) {
        selectedMaterial = material
    }
}
