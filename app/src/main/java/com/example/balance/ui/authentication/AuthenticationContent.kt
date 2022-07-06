package com.example.balance.ui.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
fun AuthenticationContent(
    id: Int,
    padding: PaddingValues,
    navigateToUsersScreens: () -> Unit,
    navigateToUpdateUserSettings: (id: Int) -> Unit,
    viewModel: AuthenticateViewModel = hiltViewModel()
) {
    var password by remember { mutableStateOf("") }

    MyForm {
        MyTextField(
            hint =  "Type a user password...",
            label = "Password",
            value = password,
            onValueChange = { text -> password = text },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.PasswordDone
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        MyButton(
            text = "Authenticate",
            onClick = {
                viewModel.authenticate()
                navigateToUpdateUserSettings(id)
            },
            colors = listOf(
                MyButtonColor1,
                MyButtonColor2
            )
        )
    }
}