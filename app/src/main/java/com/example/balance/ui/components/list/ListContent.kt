package com.example.balance.ui.components.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@ExperimentalMaterialApi
fun <T>ListContent(
    padding: PaddingValues,
    navigateToUpdateItemScreen: (id: Int) -> Unit,
    getList: () ->List<T>,
    getSearch: () -> List<T>,
    search: (text: String) -> Unit,
    getItemId: (item: T) -> Int,
    getItemText: (item: T) -> String,
    deleteItem: (item: T) -> Unit
) {
    var text by remember { mutableStateOf("") }
    Column {
        ListSearchBar(
            padding = padding,
            text = text,
            onTextChange = {
                search(it)
                text = it
            }
        )
        val list: List<T> = if (text.isNotEmpty()) getSearch() else getList()
        ItemList(
            padding = padding,
            navigateToUpdateCustomerScreen = navigateToUpdateItemScreen,
            modifier = Modifier
                .weight(1f),
            list = list,
            getItemId = getItemId,
            getItemText = getItemText,
            deleteItem = deleteItem
        )
        ListFooter(
            size = list.size,
            modifier = Modifier.padding(10.dp)
        )
    }
}