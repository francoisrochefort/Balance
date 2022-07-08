package com.example.balance.ui.materials.update_material

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.repo.customer.CustomerRepositoryImpl
import com.example.balance.repo.material.MaterialRepositoryImpl
import com.example.balance.ui.components.ObjectAlreadyExistExceptionAlertDialog
import com.example.balance.ui.components.list.ListEvent
import com.example.balance.ui.customers.update_customer.UpdateCustomerEvent
import com.example.balance.ui.materials.update_material.UpdateMaterialContent
import com.example.balance.ui.materials.update_material.UpdateMaterialTopBar
import com.example.balance.ui.materials.update_material.UpdateMaterialViewModel

@Composable
fun UpdateMaterialScreen(
    id: Int,
    navigateToMaterialsScreen: () -> Unit,
    viewModel: UpdateMaterialViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        viewModel.getMaterial(id)
        viewModel.event.collect { event ->
            when (event) {
                is ListEvent.OnError -> {
                    when (event.exception) {
                        is MaterialRepositoryImpl.MaterialAlreadyExists -> {
                            showDialog = true
                        }
                    }
                }
                is ListEvent.OnUpdate -> {
                    navigateToMaterialsScreen()
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        topBar = {
            UpdateMaterialTopBar(
                navigateToMaterialsScreen = navigateToMaterialsScreen
            )
        },
        content = { padding ->
            UpdateMaterialContent(
                padding = padding,
                id = id
            )
        }
    )

    if (showDialog) {
        ObjectAlreadyExistExceptionAlertDialog(
            hideDialog = {
                showDialog = false
            },
            onReplace = {
                viewModel.updateMaterial(true)
            }
        )
    }
}