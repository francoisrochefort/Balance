package com.example.balance.ui.customer_vehicles.customer_vehicles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.repo.vehicle.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerVehiclesViewModel  @Inject constructor(
    private val repo: VehicleRepository
): ViewModel() {

    var vehicles by mutableStateOf(emptyList<Vehicle>())
    var search by mutableStateOf(emptyList<Vehicle>())

    fun getVehicles(customerId: Int) {
        viewModelScope.launch {
            repo.getVehiclesFromRoom(customerId).collect { response ->
                vehicles = response
            }
        }
    }

    fun getSearch(customerId: Int, text: String) {
        viewModelScope.launch {
            repo.getSearchFromRoom(customerId, text).collect { response ->
                search = response
            }
        }
    }

    fun deleteVehicle(vehicle: Vehicle) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteVehicleFromRoom(vehicle)
        }
    }

}