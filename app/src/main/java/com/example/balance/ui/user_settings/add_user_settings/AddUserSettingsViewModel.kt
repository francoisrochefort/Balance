package com.example.balance.ui.user_settings.add_user_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.balance.data.user_settings.UserSettings
import com.example.balance.repo.user_settings.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserSettingsViewModel @Inject constructor(
    private val repo: UserSettingsRepository
) : ViewModel() {

    fun addUserSettings(userSettings: UserSettings) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUserSettingsFromRoom(userSettings)
        }
    }
}