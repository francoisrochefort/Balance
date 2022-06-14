package com.example.balance.ui.user_settings.add_user_settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.data.user_settings.UserSettings

@Composable
fun AddUserSettingsContent(
    padding: PaddingValues,
    navigateToUsersScreen: () -> Unit,
    userId: Int,
    viewModel: AddUserSettingsViewModel = hiltViewModel()
) {
    var enableVehicleManagement by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    var language by remember { mutableStateOf("") }
    var companyInfo by remember { mutableStateOf("") }
    var couponNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = enableVehicleManagement,
            onValueChange = { text -> enableVehicleManagement = text },
            placeholder = {
                Text(
                    text = "Enable vehicle management..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = dateTime,
            onValueChange = { text -> dateTime = text },
            placeholder = {
                Text(
                    text = "Date time..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = language,
            onValueChange = { text -> language = text },
            placeholder = {
                Text(
                    text = "Type the language..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = companyInfo,
            onValueChange = { text -> companyInfo = text },
            placeholder = {
                Text(
                    text = "Type the company info..."
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = couponNumber,
            onValueChange = { text -> couponNumber = text },
            placeholder = {
                Text(
                    text = "Type the coupon number..."
                )
            }
        )
        Button(
            onClick = {
                val userSettings = UserSettings(
                    enableVehicleManagement = enableVehicleManagement.toBoolean(),
                    dateTime = dateTime,
                    language = language,
                    companyInfo = companyInfo,
                    couponNumber = couponNumber,
                    userId = userId
                )
                viewModel.addUserSettings(userSettings)
                navigateToUsersScreen()
            }
        ) {
            Text(
                text = "Add"
            )
        }
    }
}