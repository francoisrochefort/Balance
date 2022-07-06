package com.example.balance.ui.customers.customers

import android.content.Context
import android.widget.Toast
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.balance.R
import com.example.balance.ui.components.list.AddListItemFAB
import com.example.balance.ui.components.list.ListContent
import com.example.balance.ui.components.list.ListScreen
import com.example.balance.ui.components.list.ListTopBar
import com.example.balance.ui.theme.MyCustomerMenuColor1
import com.example.balance.ui.theme.MyCustomerMenuColor2
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomersScreen(
    navigateToAddCustomerScreen: () -> Unit,
    navigateToUpdateCustomerScreen: (id: Int) -> Unit,
    viewModel: CustomersViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val context: Context = LocalContext.current

    viewModel.getCustomers()

    LaunchedEffect(key1 = true) {
        viewModel.event.collect { event ->
            when (event) {
                is DeleteCustomerEvent.OnDelete -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = context.getString(R.string.customer_deleted),
                        actionLabel = context.getString(R.string.undo)
                    )
                    if (result == SnackbarResult.ActionPerformed)
                        viewModel.undoDelete()
                }
                is DeleteCustomerEvent.OnError -> {
                    Toast.makeText(context, event.exception.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ListTopBar(
                title = "Customers"
            )
        },
        floatingActionButton = {
            AddListItemFAB(
                navigateToAddItemScreen = navigateToAddCustomerScreen
            )
        },
        content = { padding ->
            ListContent(
                padding = padding,
                navigateToUpdateItemScreen = navigateToUpdateCustomerScreen,
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
                deleteItem =  {
                    viewModel.deleteCustomer(it)
                },
                colors = listOf(
                    MyCustomerMenuColor1,
                    MyCustomerMenuColor2
                )
            )
        }
    )
}