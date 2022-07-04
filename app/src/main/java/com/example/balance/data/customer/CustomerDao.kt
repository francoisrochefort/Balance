package com.example.balance.data.customer

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customers ORDER BY name ASC")
    fun getCustomers(): Flow<List<Customer>>

    @Query("SELECT * FROM customers WHERE name LIKE :text || '%' ORDER BY name ASC")
    fun getSearch(text: String): Flow<List<Customer>>

    @Query("SELECT * FROM customers WHERE id = :id")
    fun getCustomer(id: Int): Flow<Customer>

    @Query("SELECT * FROM customers WHERE name = :name")
    fun getCustomerByName(name: String): Flow<Customer>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCustomer(customer: Customer)

    @Update
    fun updateCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)
}

