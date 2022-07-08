package com.example.balance.ui.authentication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.repo.user.UserRepository
import com.example.balance.data.db.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticateViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    var user by mutableStateOf(User("", ""))

    fun getUser(id: Int) {
        viewModelScope.launch {
            repo.getUserFromRoom(id).collect { response ->
                user = response
            }
        }
    }

    fun updatePassword(password: String) {
        user = user.copy(password = password)
    }

    fun authenticate() {
        /*viewModelScope.launch(Dispatchers.IO) {
            repo.updateUserSettingsFromRoom(userSettings)
        }*/
    }
}