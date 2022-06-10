package com.example.balance.ui.materials.materials

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.ui.components.list.ListScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MaterialsScreen(
    navigateToAddMaterialScreen: () -> Unit,
    navigateToUpdateMaterialScreen: (id: Int) -> Unit,
    viewModel: MaterialsViewModel = hiltViewModel()
) {
    ListScreen(
        title = "Materials",
        navigateToAddItemScreen = navigateToAddMaterialScreen,
        navigateToUpdateItemScreen = navigateToUpdateMaterialScreen,
        fetchList = {
            viewModel.getMaterials()
        },
        getList = {
            viewModel.materials
        },
        getSearch = {
            viewModel.search
        },
        search = { text ->
            viewModel.getSearch(text)
        },
        getItemId = {
            it.id
        },
        getItemText = {
            it.name
        },
        deleteItem = {
            viewModel.deleteMaterial(it)
        }
    )
}