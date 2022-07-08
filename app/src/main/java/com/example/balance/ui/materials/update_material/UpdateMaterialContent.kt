package com.example.balance.ui.materials.update_material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.material.Material
import com.example.balance.ui.components.MyButton
import com.example.balance.ui.components.MyForm
import com.example.balance.ui.components.MyTextField
import com.example.balance.ui.components.TextDone
import com.example.balance.ui.materials.update_material.UpdateMaterialViewModel
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun UpdateMaterialContent(
    padding: PaddingValues,
    id: Int,
    viewModel: UpdateMaterialViewModel = hiltViewModel()
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
            text = "Update",
            onClick = {
                viewModel.updateMaterial()
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}