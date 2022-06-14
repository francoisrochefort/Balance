package com.example.balance.ui.users.add_user

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun AddUserScreen(
    navigateToUsersScreen: () -> Unit,
    navigateToAddUserSettingsScreen: (id: Int) -> Unit
) {
    Scaffold(
        topBar = {
            AddUserTopBar(
                navigateToUsersScreen = navigateToUsersScreen
            )
        },
        content = { padding ->
            AddUserContent(
                padding = padding,
                navigateToAddUserSettingsScreen = navigateToAddUserSettingsScreen
            )
        }
    )
}