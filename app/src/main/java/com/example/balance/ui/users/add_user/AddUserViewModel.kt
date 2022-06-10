package com.example.balance.ui.users.add_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.user.User
import com.example.balance.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    fun addUser(material: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUserToRoom(material)
        }
    }
}