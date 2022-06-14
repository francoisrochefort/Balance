package com.example.balance.data.user_settings

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_settings")
data class UserSettings(
    @ColumnInfo(name = "enable_vehicle_management")
    var enableVehicleManagement: Boolean,
    @ColumnInfo(name = "date_time")
    var dateTime: String, //Date?,
    var language: String,
    @ColumnInfo(name = "company_info")
    var companyInfo: String,
    @ColumnInfo(name = "coupon_number")
    var couponNumber: String,
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    var userId: Int = 0
)