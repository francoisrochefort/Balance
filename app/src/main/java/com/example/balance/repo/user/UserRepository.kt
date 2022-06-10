package com.example.balance.repo.user

import com.example.balance.data.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsersFromRoom(): Flow<List<User>>
    suspend fun getSearchFromRoom(name: String): Flow<List<User>>
    suspend fun getUserFromRoom(id: Int): Flow<User>

    suspend fun addUserToRoom(user: User)
    suspend fun deleteUserFromRoom(user: User)
}