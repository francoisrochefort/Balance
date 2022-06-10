package com.example.balance.repo.user

import com.example.balance.data.user.User
import com.example.balance.data.user.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun getUsersFromRoom() = userDao.getUsers()
    override suspend fun getSearchFromRoom(name: String) = userDao.getSearch(name)
    override suspend fun getUserFromRoom(id: Int) = userDao.getUser(id)

    override suspend fun addUserToRoom(user: User)  = userDao.addUser(user)
    override suspend fun deleteUserFromRoom(user: User)  = userDao.deleteUser(user)
}