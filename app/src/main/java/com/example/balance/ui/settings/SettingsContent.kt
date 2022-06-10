package com.example.balance.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.balance.Routes

@Composable
fun SettingsContent(
    padding: PaddingValues,
    map: Map<String, ()-> Unit>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(padding)
    ) {
        for ((k, v) in map) {
            Setting(navigateTo = v, name = k)
        }
    }
}

