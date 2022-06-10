package com.example.balance.ui.users.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.user.User
import com.example.balance.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    var users by mutableStateOf(emptyList<User>())
    var search by mutableStateOf(emptyList<User>())

    fun getUsers() {
        viewModelScope.launch {
            repo.getUsersFromRoom().collect { response ->
                users = response
            }
        }
    }

    fun getSearch(text: String) {
        viewModelScope.launch {
            repo.getSearchFromRoom(text).collect { response ->
                search = response
            }
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteUserFromRoom(user)
        }
    }
}