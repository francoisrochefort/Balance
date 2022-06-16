package com.example.balance.ui.users.add_user

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.user.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun AddUserContent(
    padding: PaddingValues,
    navigateToAddUserSettingsScreen: (id: Int) -> Unit,
    viewModel: AddUserViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.user.name,
            onValueChange = { name -> viewModel.updateName(name) },
            placeholder = {
                Text(
                    text = "Type a user name..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = viewModel.user.password,
            onValueChange = { password -> viewModel.updatePassword(password) },
            placeholder = {
                Text(
                    text = "Type a password..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {

                // TODO: user.id = 0 and is not valid; ensure the user id is passed to navigateToAddUserSettingsScreen
                viewModel.addUser()
                navigateToAddUserSettingsScreen(viewModel.user.id)
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}