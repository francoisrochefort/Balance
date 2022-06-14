package com.example.balance.data.user

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :text || '%' ORDER BY name ASC")
    fun getSearch(text: String): Flow<List<User>>

    // Used to perform user authentication
    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //fun addUser(user: User)
    fun addUser(user: User): Long

    @Delete
    fun deleteUser(user: User)
}
