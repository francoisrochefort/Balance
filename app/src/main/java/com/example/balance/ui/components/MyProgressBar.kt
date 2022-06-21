package com.example.balance.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyProgressBar() {
    /*Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue
        )
    }*/

    @Composable
    fun Heart() {
        Canvas(modifier = Modifier
            .fillMaxSize(),
            onDraw = {
                val path = Path().apply {
                    heartPath(Size(120f, 120f))
                }

                drawPath(
                    path = path,
                    color = Color.Red,
                )
            }
        )
    }
}

private fun DrawScope.drawHereLips() {

}

@Preview
@Composable
fun MyProgressBarPreview() {
    MyProgressBar()
}