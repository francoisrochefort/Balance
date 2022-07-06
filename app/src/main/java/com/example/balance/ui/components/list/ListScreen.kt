package com.example.balance.ui.components.list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color

@Composable
@ExperimentalMaterialApi
fun <T>ListScreen(
    title: String,
    navigateToAddItemScreen: () -> Unit,
    navigateToUpdateItemScreen: (id: Int) -> Unit,
    fetchList: () -> Unit,
    getList: () -> List<T>,
    getSearch: () -> List<T>,
    search: (text: String) -> Unit,
    getItemId: (item: T) -> Int,
    getItemText: (item: T) -> String,
    deleteItem: (item: T) -> Unit,
    colors: List<Color>
) {
    LaunchedEffect(Unit) {
        fetchList()
    }
    Scaffold(
        topBar = {
            ListTopBar(
                title = title
            )
        },
        floatingActionButton = {
            AddListItemFAB(
                navigateToAddItemScreen = navigateToAddItemScreen
            )
        },
        content = { padding ->
            ListContent(
                padding = padding,
                navigateToUpdateItemScreen = navigateToUpdateItemScreen,
                getList = getList,
                getSearch = getSearch,
                search = search,
                getItemId = getItemId,
                getItemText = getItemText,
                deleteItem = deleteItem,
                colors = colors
            )
        }
    )
}