package com.example.balance.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
    text:String,
    onClick: () -> Unit,
    colors: List<Color>,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(8.dp))
            .background(Brush.verticalGradient(colors = colors))
    ) {
        Text(
            text = text.uppercase(),
            Modifier
                .padding(
                    start = 20.dp,
                    top = 9.dp,
                    end = 20.dp,
                    bottom = 9.dp
                ),
            color = Color(0xFFD0D3D4)
        )
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    MyButton(
        text = "Button1",
        onClick = {},
        colors = listOf(
            Color(0xFF2F8DFD),
            Color(0xFF042058)
        )
    )
}