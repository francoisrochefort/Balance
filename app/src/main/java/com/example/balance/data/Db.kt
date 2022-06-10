package com.example.balance.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.balance.data.customer.Customer
import com.example.balance.data.customer.CustomerDao
import com.example.balance.data.material.Material
import com.example.balance.data.material.MaterialDao
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.data.vehicle.VehicleDao
import com.example.balance.data.user.User
import com.example.balance.data.user.UserDao

@Database(
    entities = [
        Customer::class,
        Vehicle::class,
        Material::class,
        User::class
    ],
    version = 1
)
abstract class Db: RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun materialDao(): MaterialDao
    abstract fun userDao(): UserDao
}