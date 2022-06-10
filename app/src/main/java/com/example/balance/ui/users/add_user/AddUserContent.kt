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

@Composable
fun AddUserContent(
    padding: PaddingValues,
    navigateToUsersScreen: () -> Unit,
    viewModel: AddUserViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    text = "Type a user name..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = password,
            onValueChange = { text -> password = text },
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
                val addUser = User(name, password)
                viewModel.addUser(addUser)
                navigateToUsersScreen()
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}