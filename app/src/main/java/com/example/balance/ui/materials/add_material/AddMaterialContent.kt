package com.example.balance.ui.materials.add_material

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.material.Material

@Composable
fun AddMaterialContent(
    padding: PaddingValues,
    navigateToMaterialsScreen: () -> Unit,
    viewModel: AddMaterialViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { text -> name = text },
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
                val addMaterial = Material(name)
                viewModel.addMaterial(addMaterial)
                navigateToMaterialsScreen()
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}