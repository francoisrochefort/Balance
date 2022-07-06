package com.example.balance.ui.users.add_user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.Routes
import com.example.balance.data.user.User
import com.example.balance.repo.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiEvent {
    //object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    //data class ShowSnackBar(val message: String, val action: String? = null): UiEvent()
}

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    var user by mutableStateOf(User("", ""))

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun updateName(name: String) {
        user = user.copy(name = name)
    }

    fun updatePassword(password: String) {
        user = user.copy(password = password)
    }

    fun addUser() {
        viewModelScope.launch(Dispatchers.IO) {
            val id: Long = repo.addUserToRoom(user)
            _uiEvent.send(UiEvent.Navigate(Routes.ADD_USER_SETTINGS + "/${id}"))
        }
    }
}