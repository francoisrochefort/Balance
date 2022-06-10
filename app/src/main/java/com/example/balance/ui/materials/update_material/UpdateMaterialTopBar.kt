package com.example.balance.ui.materials.update_material

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun UpdateMaterialTopBar(
    navigateToMaterialsScreen: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = "Update material"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navigateToMaterialsScreen()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back.",
                )
            }
        }
    )
}