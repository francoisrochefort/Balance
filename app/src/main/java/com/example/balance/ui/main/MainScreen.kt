package com.example.balance.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(navigateToSettingsScreen: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center) {
        Button(
            onClick = navigateToSettingsScreen
        ) {
            Text(text = "Settings")
        }
    }
}