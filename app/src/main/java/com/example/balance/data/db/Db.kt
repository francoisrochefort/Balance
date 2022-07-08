package com.example.balance.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.balance.data.db.customer.Customer
import com.example.balance.data.db.customer.CustomerDao
import com.example.balance.data.db.material.Material
import com.example.balance.data.db.material.MaterialDao
import com.example.balance.data.db.vehicle.Vehicle
import com.example.balance.data.db.vehicle.VehicleDao
import com.example.balance.data.db.user.User
import com.example.balance.data.db.user.UserDao
import com.example.balance.data.db.user_settings.UserSettings
import com.example.balance.data.db.user_settings.UserSettingsDao

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