package com.example.balance.ui.users.add_user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.MyButton
import com.example.balance.ui.components.MyForm
import com.example.balance.ui.components.MyTextField
import com.example.balance.ui.components.PasswordDone
import com.example.balance.ui.theme.MyButtonColor1
import com.example.balance.ui.theme.MyButtonColor2

@Composable
fun AddUserContent(
    padding: PaddingValues,
    navigateToAddUserSettingsScreen: (id: Int) -> Unit,
    viewModel: AddUserViewModel = hiltViewModel()
) {
    MyForm {
        MyTextField(
            hint =  "Type a user name...",
            label = "Name",
            value = viewModel.user.name,
            onValueChange = { name -> viewModel.updateName(name) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyTextField(
            hint =  "Type a user password...",
            label = "Password",
            value = viewModel.user.password,
            onValueChange = { password -> viewModel.updatePassword(password) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.PasswordDone
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyButton(
            text = "Add",
            onClick = {

                // TODO: user.id = 0 and is not valid; ensure the user id is passed to navigateToAddUserSettingsScreen
                viewModel.addUser()
                navigateToAddUserSettingsScreen(viewModel.user.id)
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}