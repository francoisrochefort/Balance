package com.example.balance.ui.customers.customers

import android.content.Context
import android.widget.Toast
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.R
import com.example.balance.ui.components.list.*
import com.example.balance.ui.theme.MyCustomerMenuColor1
import com.example.balance.ui.theme.MyCustomerMenuColor2
import com.example.balance.ui.theme.MyMaterialMenuColor1
import com.example.balance.ui.theme.MyMaterialMenuColor2

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomersScreen(
    navigateToAddCustomerScreen: () -> Unit,
    navigateToUpdateCustomerScreen: (id: Int) -> Unit,
    viewModel: CustomersViewModel = hiltViewModel()
) {
    val context: Context = LocalContext.current
    ListScreen(
        title = context.getString(R.string.customers),
        navigateToAddItemScreen = navigateToAddCustomerScreen,
        navigateToUpdateItemScreen = navigateToUpdateCustomerScreen,
        fetchList = {
            viewModel.getCustomers()
        },
        getList = {
            viewModel.customers
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
            viewModel.deleteCustomer(it)
        },
        colors = listOf(
            MyCustomerMenuColor1,
            MyCustomerMenuColor2
        ),
        getEventFlow = {
            viewModel.event
        },
        getSnackBarMessage = {
            context.getString(R.string.material_deleted)
        },
        undoDelete = {
            viewModel.undoDelete()
        }
    )
}