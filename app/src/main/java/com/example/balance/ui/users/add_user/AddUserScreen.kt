package com.example.balance.ui.users.add_user

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun AddUserScreen(
    navigateToAddUserSettings: () -> Unit
) {
    Scaffold(
        topBar = {
            AddUserTopBar(
                navigateToUsersScreen = navigateToAddUserSettings
            )
        },
        content = { padding ->
            AddUserContent(
                padding = padding,
                navigateToUsersScreen = navigateToAddUserSettings
            )
        }
    )
}