package com.example.balance.repo.user_settings

import com.example.balance.data.user_settings.UserSettings
import com.example.balance.data.user_settings.UserSettingsDao
import kotlinx.coroutines.flow.Flow

class UserSettingsRepositoryImpl(
    private val userSettingsDao: UserSettingsDao
): UserSettingsRepository {
    override suspend fun getUserSettingsFromRoom(user_id: Int) = userSettingsDao.getUserSettings(user_id)
    override suspend fun addUserSettingsFromRoom(userSettings: UserSettings) = userSettingsDao.addUserSettings(userSettings)

    override suspend fun updateUserSettingsFromRoom(userSettings: UserSettings) = userSettingsDao.updateUserSettings(userSettings)
    override suspend fun deleteUserSettingsFromRoom(userSettings: UserSettings) = userSettingsDao.deleteUserSettings(userSettings)
}