package com.example.balance.ui.customer_vehicles.add_vehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.repo.vehicle.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVehicleViewModel @Inject constructor(
    private val repo: VehicleRepository
) : ViewModel() {

    fun addVehicle(vehicle: Vehicle) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addVehicleToRoom(vehicle)
        }
    }
}