package com.example.balance.ui.settings

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Setting(navigateTo: () -> Unit, name: String, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 20.dp,
                end =20.dp,
                top = 20.dp,
            )
            .fillMaxWidth(),
        elevation = 5.dp,
        onClick = {
            navigateTo()
        }
    ) {
        Text(
            text = name,
            modifier = Modifier
                .height(75.dp)
                .wrapContentHeight()
                .padding(10.dp)
        )
    }
}