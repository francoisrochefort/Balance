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
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.toSize

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(Color.Gray, Color.Black),
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(colors = colors))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text.uppercase(), color = MyButtonTextColor)
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton(
        text = "Button1",
        onClick = {},
        Modifier.width(250.dp)
    )
}

@Composable
fun <T> MyDropDownMenu(
    hint: String,
    text: String?,
    list: List<T>,
    getItemText: (item: T) -> String,
    onClick: (item: T) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var width by remember { mutableStateOf(Size.Zero) }

    Column(modifier = modifier) {
        MyButton(
            onClick = {
                expanded = true
            },
            text = if (text == null) "$hint:${stringResource(R.string.none)}" else "$hint: $text",
            modifier = modifier
                .onGloballyPositioned {
                    width = it.size.toSize()
                }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { width.width.toDp() })
        ) {
            for (item: T in list) {
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onClick(item)
                    }
                ) {
                    Text(text = getItemText(item))
                }
            }
        }
    }
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
    color: Color = MyTextColor,
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
            color = color
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
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
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
                text = viewModel.tare.toString(),
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
            val progressBarHeight: Int = 20
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
            text = viewModel.currentWeight.toString(),
            Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(padding))

        // Last Bucket, Bucket Count and Expected Load
        Row(
            Modifier.fillMaxWidth()
        ) {
            MyText(
                hint = "Last Bucket",
                text = viewModel.lastBucket.toString(),
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(padding))
            MyText(
                hint = "Bucket Count",
                text = viewModel.bucketCount.toString(),
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(padding))
            MyText(
                hint = "Expected Load",
                text = viewModel.expectedLoad.toString(),
                Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(padding))

        // Total Load
        MyText(
            hint = "Total Load",
            text = viewModel.totalLoad.toString(),
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ControlPanel(
    onMainMenu: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
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
        MyDropDownMenu(
            hint = stringResource(R.string.user),
            text = if (viewModel.selectedUser == null) null else viewModel.selectedUser!!.toString(),
            list = viewModel.users,
            getItemText = {
                it.toString()
            },
            onClick = {
                viewModel.selectUser(it)
            },
            Modifier.fillMaxWidth()
        )

        // Client
        MyDropDownMenu(
            hint = stringResource(R.string.customer),
            text = if (viewModel.selectedCustomer == null) null else viewModel.selectedCustomer!!.toString(),
            list = viewModel.customers,
            getItemText = {
                it.toString()
            },
            onClick = {
                viewModel.selectCustomer(it)
            },
            Modifier.fillMaxWidth()
        )

        // Vehicle
        MyDropDownMenu(
            hint = stringResource(R.string.vehicle),
            text = if (viewModel.selectedVehicle == null) null else viewModel.selectedVehicle!!.toString(),
            list = viewModel.vehicles,
            getItemText = {
                it.toString()
            },
            onClick = {
                viewModel.selectVehicle(it)
            },
            Modifier.fillMaxWidth()
        )

        // Material
        MyDropDownMenu(
            hint = stringResource(R.string.material),
            text = if (viewModel.selectedMaterial == null) null else viewModel.selectedMaterial!!.toString(),
            list = viewModel.materials,
            getItemText = {
                it.toString()
            },
            onClick = {
                viewModel.selectMaterial(it)
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
