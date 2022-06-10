package com.example.balance.data.user_settings

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_settings")
data class UserSettings(
    var enableVehicleManagement: Boolean,
    var dateTime: Date,
    var language: String,
    var companyInfo: String,
    @NonNull
    @PrimaryKey
    var userId: Int = 0
)