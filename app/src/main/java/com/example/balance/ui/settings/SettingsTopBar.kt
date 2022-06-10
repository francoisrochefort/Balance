package com.example.balance.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun SettingsTopBar() {
    TopAppBar (
        title = {
            Column {
                Text(
                    text = "Settings"
                )
            }
        }
    )
}