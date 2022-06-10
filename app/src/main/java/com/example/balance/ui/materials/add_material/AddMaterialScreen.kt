package com.example.balance.ui.materials.add_material

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.balance.ui.materials.add_material.AddMaterialContent
import com.example.balance.ui.materials.add_material.AddMaterialTopBar

@Composable
fun AddMaterialScreen(
    navigateToMaterialsScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            AddMaterialTopBar(
                navigateToMaterialsScreen = navigateToMaterialsScreen
            )
        },
        content = { padding ->
            AddMaterialContent(
                padding = padding,
                navigateToMaterialsScreen = navigateToMaterialsScreen
            )
        }
    )
}