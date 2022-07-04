package com.example.balance.repo.customer

import com.example.balance.data.customer.Customer
import com.example.balance.data.customer.CustomerDao
import kotlinx.coroutines.flow.Flow

class CustomerRepositoryImpl(
    private val customerDao: CustomerDao
) : CustomerRepository {
    override suspend fun getCustomersFromRoom() = customerDao.getCustomers()
    override suspend fun getSearchFromRoom(text: String) = customerDao.getSearch(text)
    override suspend fun getCustomerFromRoom(id: Int) = customerDao.getCustomer(id)

    //override suspend fun addCustomerToRoom(customer: Customer) = customerDao.addCustomer(customer)
    override suspend fun addCustomerToRoom(customer: Customer) {
        val existing: Flow<Customer>? = customerDao.getCustomerByName(customer.name)
        if (existing != null)
            throw Exception("Customer ${customer.name} already exists within the database")
        else
            customerDao.addCustomer(customer)
    }

    override suspend fun updateCustomerInRoom(customer: Customer) = customerDao.updateCustomer(customer)
    override suspend fun deleteCustomerFromRoom(customer: Customer) = customerDao.deleteCustomer(customer)

    class CustomerAlreadyExists(val name: String): Exception("Customer $name already exists")
}