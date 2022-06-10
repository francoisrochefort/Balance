package com.example.balance.ui.materials.update_material

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.materials.update_material.UpdateMaterialContent
import com.example.balance.ui.materials.update_material.UpdateMaterialTopBar
import com.example.balance.ui.materials.update_material.UpdateMaterialViewModel

@Composable
fun UpdateMaterialScreen(
    id: Int,
    navigateToMaterialsScreen: () -> Unit,
    viewModel: UpdateMaterialViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getMaterial(id)
    }
    Scaffold(
        topBar = {
            UpdateMaterialTopBar(
                navigateToMaterialsScreen = navigateToMaterialsScreen
            )
        },
        content = { padding ->
            UpdateMaterialContent(
                padding = padding,
                id = id,
                navigateToMaterialsScreen = navigateToMaterialsScreen
            )
        }
    )
}