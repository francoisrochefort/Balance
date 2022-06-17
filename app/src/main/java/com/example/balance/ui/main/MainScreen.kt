package com.example.balance.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    navigateToSettingsScreen: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getUsers()
        viewModel.getCustomers()
        viewModel.getMaterials()
    }
    Scaffold(
        content = { padding ->
            MainContent(
                padding = padding,
                navigateToSettingsScreen = navigateToSettingsScreen
            )
        }
    )
}