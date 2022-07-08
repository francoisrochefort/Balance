package com.example.balance.data.user

import androidx.room.*
import com.example.balance.data.customer.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :text || '%' ORDER BY name ASC")
    fun getSearch(text: String): Flow<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT * FROM users WHERE name = :name")
    fun getUserByName(name: String): User?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User): Long

    @Delete
    fun deleteUser(user: User)
}
