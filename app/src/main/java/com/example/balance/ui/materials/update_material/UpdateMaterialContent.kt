package com.example.balance.ui.materials.update_material

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.material.Material
import com.example.balance.ui.materials.update_material.UpdateMaterialViewModel

@Composable
fun UpdateMaterialContent(
    padding: PaddingValues,
    id: Int,
    navigateToMaterialsScreen: () -> Unit,
    viewModel: UpdateMaterialViewModel = hiltViewModel()
) {
    val name = viewModel.material.name

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name -> viewModel.updateName(name) },
            placeholder = {
                Text(
                    text = "Type a material name..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                val updatedMaterial = Material(name, id)
                viewModel.updateMaterial(updatedMaterial)
                navigateToMaterialsScreen()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}