package com.example.balance.ui.materials.add_material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.MyButton
import com.example.balance.ui.components.MyForm
import com.example.balance.ui.components.MyTextField
import com.example.balance.ui.components.TextDone
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun AddMaterialContent(
    padding: PaddingValues,
    navigateToMaterialsScreen: () -> Unit,
    viewModel: AddMaterialViewModel = hiltViewModel()
) {
    MyForm {
        MyTextField(
            hint =  "Type a material name...",
            label = "Name",
            value = viewModel.material.name,
            onValueChange = { name -> viewModel.updateName(name) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.TextDone
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyButton(
            text = "Add",
            onClick = {
                viewModel.addMaterial()
                navigateToMaterialsScreen()
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}