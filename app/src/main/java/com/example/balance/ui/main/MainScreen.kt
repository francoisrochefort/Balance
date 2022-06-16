package com.example.balance.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    navigateToSettingsScreen: () -> Unit
) {
    Scaffold(
        content = { padding ->
            MainContent(
                padding = padding,
                navigateToSettingsScreen = navigateToSettingsScreen
            )
        }
    )
}