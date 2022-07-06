package com.example.balance.ui.components.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.balance.data.material.Material
import com.example.balance.ui.components.MyGradientBox
import com.example.balance.ui.components.MyCard
import com.example.balance.ui.theme.*

@Composable
@ExperimentalMaterialApi
fun <T>ListItem(
    item: T,
    navigateToUpdateItemScreen: (id: Int) -> Unit,
    getItemId: (item: T) -> Int,
    getItemText: (item: T) -> String,
    deleteItem: (item: T) -> Unit,
    colors: List<Color>
) {
    MyCard(
        onClick = {
            navigateToUpdateItemScreen(getItemId(item))
        }
    ) {
        MyGradientBox(
            colors = colors
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.90f)
                ) {
                    Text(
                        text = getItemText(item),
                        color = MyListItemTextColor
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
                        tint = MyListItemIconColor
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ListItemPreview() {
    ListItem(
        item = Material(name = "Gold"),
        navigateToUpdateItemScreen = {},
        getItemId = { material ->
            material.id
        },
        getItemText = { material ->
            material.name
        },
        deleteItem = { },
        colors = listOf(MyButtonColor1, MyButtonColor2)
    )
}