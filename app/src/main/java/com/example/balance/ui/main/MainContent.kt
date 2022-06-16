package com.example.balance.ui.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.balance.R
import com.example.balance.ui.theme.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 32.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Composable
fun <T>MyDropDownMenu(
    list: List<T>,
    getItemId: (item: T) -> Int,
    getItemText: (item: T) -> String
) {
    var expanded by remember { mutableStateOf(false) }
    var text: String? by remember { mutableStateOf(null) }
    var id: Int? by remember { mutableStateOf(null) }

    Column(Modifier.padding(20.dp)) {
        Button(
            onClick = {
                expanded = true
            }
        ) {
            Text(text = if (text == null) "None" else text!!)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (item: T in list) {
                DropdownMenuItem(
                    onClick = {
                        id = getItemId(item)
                        text = getItemText(item)
                        expanded = false
                    }
                ) {
                    Text(text = getItemText(item))
                }
            }
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton(
        text = "Button1",
        textColor = Color.LightGray,
        gradient = Brush.verticalGradient(colors = listOf(Color.Gray, Color.Black)),
        onClick = {}
    )
}


@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text.uppercase(),
            color = MyButtonTextColor
        )
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    MyButton(
        text = "Button1",
        onClick = {}
    )
}

@Composable
fun MyText(
    hint: String,
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyButtonTextColor,
) {
    Column(
        modifier = modifier
            .border(
                width = dimensionResource(id = R.dimen.MyTextBorderWidth),
                color = MyTextBorderColor,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.MyTextBorderRadius))
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = 10.dp,
                    top = 5.dp
                ),
            text = text.uppercase(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            color = MyTextColor
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    bottom = 5.dp
                ),
            text = hint.uppercase(),
            fontSize = 10.sp,
            color = MyTextHintColor
        )
    }
}

@Preview
@Composable
fun MyTextPreview() {
    MyText(hint = "Hint", text = "Text")
}

@Composable
fun DashBoard(
    modifier: Modifier = Modifier
) {
    val padding: Dp = dimensionResource(id = R.dimen.MyWidgetPadding)

    Column(
        modifier = modifier
    ) {

        // Units and Tare
        Row {
            MyText(
                hint = "Units",
                text = "TON",
                Modifier.weight(1f)
            )
            Spacer(Modifier.weight(2f))
            MyText(
                hint = "TARE",
                text = "1000",
                Modifier.weight(2f)
            )
        }
        Spacer(modifier = Modifier.height(padding))

        // Progress bar
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            val progressBarHeight: Int = 75
            LinearProgressIndicator(
                progress = 0.7f,
                Modifier
                    .height(progressBarHeight.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically),
            )
            Spacer(modifier = Modifier.width(padding))
            Text(
                text = "35°",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = progressBarHeight.sp,
                color = MyProgressBarTextColor
            )
        }
        Spacer(modifier = Modifier.height(padding))

        // Current Weight
        MyText(
            hint = "Current Weight",
            text = "TON",
            Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(padding))

        // Last Bucket, Bucket Count and Expected Load
        Row(
            Modifier.fillMaxWidth()
        ) {
            MyText(
                hint = "Last Bucket",
                text = "100000",
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(padding))
            MyText(
                hint = "Bucket Count",
                text = "100",
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(padding))
            MyText(
                hint = "Expected Load",
                text = "1000000",
                Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(padding))

        // Current Weight
        MyText(
            hint = "Total Load",
            text = "1000000",
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ControlPanel(
    onMainMenu: () -> Unit,
    modifier: Modifier = Modifier
) {
    val padding: Dp = dimensionResource(id = R.dimen.MyWidgetPadding)

    // Main Menu and Pause
    Column {
        Row {
            MyButton(
                text = "Main Menu",
                onClick = {
                    onMainMenu()
                },
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(padding))
            MyButton(
                text = "Pause",
                onClick = {
                },
                Modifier.weight(1f)
            )
        }

        // User
        /*MyButton(
            text = "User: Selected User",
            onClick = {
            },
            Modifier.fillMaxWidth()
        )*/
        MyDropDownMenu(
            list = listOf("Kotlin", "Java", "Visual-Basic", "Python", "C++", "ASM", "JavaScript"),
            getItemId = {
                0
            },
            getItemText = {
                it
            }
        )

        // Client
        MyButton(
            text = "Client: Selected Client",
            onClick = {
            },
            Modifier.fillMaxWidth()
        )

        // Vehicle
        MyButton(
            text = "Vehicle: Selected Vehicle",
            onClick = {
            },
            Modifier.fillMaxWidth()
        )

        // Material
        MyButton(
            text = "Material: Selected Material",
            onClick = {
            },
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    val padding: Dp = dimensionResource(id = R.dimen.MyWidgetPadding)

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Max)
        ) {
            MyButton(
                text = "Cancel Load",
                onClick = {
                },
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(padding))
            MyButton(
                text = "Cancel Last Bucket",
                onClick = {
                },
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(padding))
            MyButton(
                text = "Close Load",
                onClick = {
                },
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(padding))
            MyButton(
                text = "Close/Print",
                onClick = {
                },
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun MainContent(
    padding: PaddingValues,
    navigateToSettingsScreen: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.MyWidgetPadding)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        DashBoard()
        ControlPanel(
            onMainMenu = {
                navigateToSettingsScreen()
            }
        )
        BottomBar()
    }
}

@Preview(
    showBackground = true,
    widthDp = 500, heightDp = 800,
    backgroundColor = 0x010101,
    locale = "fr",
)
@Composable
fun MainContentPreview() {
    MainContent(
        padding = PaddingValues(dimensionResource(id = R.dimen.MyWidgetPadding)),
        navigateToSettingsScreen = {}
    )
}
