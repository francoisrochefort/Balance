package com.example.balance.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.balance.data.customer.Customer
import com.example.balance.data.customer.CustomerDao
import com.example.balance.data.material.Material
import com.example.balance.data.material.MaterialDao
import com.example.balance.data.vehicle.Vehicle
import com.example.balance.data.vehicle.VehicleDao
import com.example.balance.data.user.User
import com.example.balance.data.user.UserDao
import com.example.balance.data.user_settings.UserSettings
import com.example.balance.data.user_settings.UserSettingsDao

@Database(
    entities = [
        Customer::class,
        Vehicle::class,
        Material::class,
        User::class,
        UserSettings::class
    ],
    version = 1
)
//@TypeConverters(Converters::class)
abstract class Db: RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun materialDao(): MaterialDao
    abstract fun userDao(): UserDao
    abstract fun userSettingsDao(): UserSettingsDao
}