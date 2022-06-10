package com.example.balance.repo.customer

import com.example.balance.data.customer.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    suspend fun getCustomersFromRoom(): Flow<List<Customer>>
    suspend fun getSearchFromRoom(name: String): Flow<List<Customer>>
    suspend fun getCustomerFromRoom(id: Int): Flow<Customer>

    suspend fun addCustomerToRoom(customer: Customer)
    suspend fun updateCustomerInRoom(customer: Customer)
    suspend fun deleteCustomerFromRoom(customer: Customer)
}