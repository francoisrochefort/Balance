package com.example.balance.ui.users.add_user

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddUserScreen(
    navigateToUsersScreen: () -> Unit,
    //navigateToAddUserSettingsScreen: (id: Int) -> Unit,
    navigate: (UiEvent.Navigate) -> Unit,
    viewModel: AddUserViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    navigate(event)
                }
                else -> Unit
            }
        }
    }
    Scaffold(
        topBar = {
            AddUserTopBar(
                navigateToUsersScreen = navigateToUsersScreen
            )
        },
        content = { padding ->
            AddUserContent(
                padding = padding,
                //navigateToAddUserSettingsScreen = navigate
            )
        }
    )
}