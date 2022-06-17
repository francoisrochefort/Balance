package com.example.balance.repo.user_settings

import com.example.balance.data.user_settings.UserSettings
import kotlinx.coroutines.flow.Flow

interface UserSettingsRepository {
    suspend fun getUserSettingsFromRoom(user_id: Int): Flow<UserSettings>
    suspend fun addUserSettingsFromRoom(userSettings: UserSettings)

    suspend fun updateUserSettingsFromRoom(userSettings: UserSettings)
    suspend fun deleteUserSettingsFromRoom(userSettings: UserSettings)
}