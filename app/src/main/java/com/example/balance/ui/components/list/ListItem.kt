package com.example.balance.ui.components.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@ExperimentalMaterialApi
fun <T>ListItem(
    item: T,
    navigateToUpdateItemScreen: (id: Int) -> Unit,
    getItemId: (item: T) -> Int,
    getItemText: (item: T) -> String,
    deleteItem: (item: T) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 5.dp,
        onClick = {
            navigateToUpdateItemScreen(getItemId(item))
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.90f)
            ){
                Text(
                    text = getItemText(item)
                )
            }
            IconButton(
                onClick = {
                    deleteItem(item)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete customer",
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}