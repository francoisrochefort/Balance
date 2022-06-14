package com.example.balance.ui.user_settings.update_user_settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UpdateUserSettingsContent(
    padding: PaddingValues,
    id: Int,
    navigateToUsersScreen: () -> Unit,
    viewModel: UpdateUserSettingsViewModel = hiltViewModel()
) {
    val enableUserSettingsManagement = viewModel.userSettings.enableVehicleManagement
    val dateTime = viewModel.userSettings.dateTime
    val language = viewModel.userSettings.language
    val companyInfo = viewModel.userSettings.companyInfo
    val couponNumber = viewModel.userSettings.couponNumber

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //
        // enableUserSettingsManagement
        //
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Enable vehicle management",
                Modifier.weight(1f)
            )
            Switch(
                checked = enableUserSettingsManagement,
                onCheckedChange = { viewModel.updateEnableVehicleManagement(it) })
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = dateTime,
            onValueChange = { dateTime -> viewModel.updateDateTime(dateTime) },
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
            onValueChange = { language -> viewModel.updateLanguage(language) },
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
            onValueChange = { companyInfo -> viewModel.updateCompanyInfo(companyInfo) },
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
            onValueChange = { couponNumber -> viewModel.updateCouponNumber(couponNumber) },
            placeholder = {
                Text(
                    text = "Type the coupon number..."
                )
            }
        )
        Button(
            onClick = {
                viewModel.updateUserSettings()
                navigateToUsersScreen()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}