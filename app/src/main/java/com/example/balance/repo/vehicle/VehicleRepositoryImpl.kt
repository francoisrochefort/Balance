package com.example.balance.repo.vehicle

import com.example.balance.data.user.User
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.data.vehicle.VehicleDao
import com.example.balance.repo.user.UserRepositoryImpl

class VehicleRepositoryImpl(

    private val vehicleDao: VehicleDao

): VehicleRepository {
    override suspend fun getVehiclesFromRoom(customerId: Int) = vehicleDao.getVehicles(customerId)
    override suspend fun getSearchFromRoom(customerId: Int, text: String) = vehicleDao.getSearch(customerId, text)
    override suspend fun getVehicleFromRoom(id: Int) = vehicleDao.getVehicle(id)

    override suspend fun addVehicleToRoom(vehicle: Vehicle, replace: Boolean) = vehicleDao.addVehicle(vehicle)
    override suspend fun updateVehicleInRoom(vehicle: Vehicle) = vehicleDao.updateVehicle(vehicle)
    override suspend fun deleteVehicleFromRoom(vehicle: Vehicle) = vehicleDao.deleteVehicle(vehicle)
}