package com.example.balance.ui.users.add_user

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
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    var user by mutableStateOf(User("", ""))

    fun updateName(name: String) {
        user = user.copy(name = name)
    }

    fun updatePassword(password: String) {
        user = user.copy(password = password)
    }

    fun addUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUserToRoom(user)
        }
    }
}