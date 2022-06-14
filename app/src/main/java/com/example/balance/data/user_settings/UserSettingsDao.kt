package com.example.balance.data.user_settings

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSettingsDao {
    @Query("SELECT * FROM user_settings WHERE user_id = :user_id LIMIT 1")
    fun getUserSettings(user_id: Int): Flow<UserSettings>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUserSettings(userSettings: UserSettings)

    @Update
    fun updateUserSettings(userSettings: UserSettings)

    @Delete
    fun deleteUserSettings(userSettings: UserSettings)
}
