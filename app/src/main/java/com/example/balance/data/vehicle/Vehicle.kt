package com.example.balance.data.vehicle

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "vehicles"
)
data class Vehicle(
    var model: String,
    var number: String,
    var plate: String,
    var capacity: Float,

    /*var year: Int,
    var kind: String,
    var color: Int,*/

    @NonNull
    var customer_id: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

) {
    override fun toString(): String {
        return model
    }
}