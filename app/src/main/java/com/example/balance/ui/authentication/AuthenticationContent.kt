package com.example.balance.ui.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthenticationContent(
    id: Int,
    padding: PaddingValues,
    navigateToUsersScreens: () -> Unit,
    navigateToUpdateUserSettings: (id: Int) -> Unit,
    viewModel: AuthenticateViewModel = hiltViewModel()
) {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = password,
            onValueChange = { text -> password = text },
            placeholder = {
                Text(
                    text = "Type your password..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                viewModel.authenticate()
                navigateToUpdateUserSettings(id)
            }
        ) {
            Text(
                text = "Authenticate"
            )
        }
    }
}