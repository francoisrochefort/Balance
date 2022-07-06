package com.example.balance

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.balance.ui.authentication.AuthenticationScreen
import com.example.balance.ui.customers.add_customer.AddCustomerScreen
import com.example.balance.ui.customer_vehicles.add_vehicle.AddVehicleScreen
import com.example.balance.ui.customer_vehicles.customer_vehicles.CustomerVehiclesScreen
import com.example.balance.ui.customers.customers.CustomersScreen
import com.example.balance.ui.main.MainScreen
import com.example.balance.ui.settings.SettingsScreen
import com.example.balance.ui.customers.update_customer.UpdateCustomerScreen
import com.example.balance.ui.customer_vehicles.update_vehicle.UpdateVehicleScreen
import com.example.balance.ui.materials.add_material.AddMaterialScreen
import com.example.balance.ui.materials.materials.MaterialsScreen
import com.example.balance.ui.materials.update_material.UpdateMaterialScreen
import com.example.balance.ui.user_settings.add_user_settings.AddUserSettingsScreen
import com.example.balance.ui.user_settings.update_user_settings.UpdateUserSettingsScreen
import com.example.balance.ui.users.add_user.AddUserScreen
import com.example.balance.ui.users.users.UsersScreen
import com.example.balance.ui.vehicles.VehiclesScreen

@Composable
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.MAIN
    ) {

        composable(
            route = Routes.MAIN
        ) {
            MainScreen(
                navigateToSettingsScreen = {
                    navController.navigate(Routes.SETTINGS)
                }
            )
        }

        composable(
            route = Routes.SETTINGS
        ) {
            SettingsScreen(
                mapOf(
                    "Customers" to {
                        navController.navigate(Routes.CUSTOMERS)
                    },
                    "Vehicles" to {
                        navController.navigate(Routes.VEHICLES)
                    },
                    "Materials" to {
                        navController.navigate(Routes.MATERIALS)
                    },
                    "Users" to {
                        navController.navigate(Routes.USERS)
                    }
                )
            )
        }

        composable(
            route = Routes.CUSTOMERS
        ) {
            CustomersScreen(
                navigateToAddCustomerScreen = {
                    navController.navigate(Routes.ADD_CUSTOMER)
                },
                navigateToUpdateCustomerScreen = { id ->
                    navController.navigate(Routes.UPDATE_CUSTOMER + "/${id}")
                }
            )
        }

        composable(
            route = Routes.UPDATE_CUSTOMER + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("id")
            UpdateCustomerScreen(
                id = id,
                navigateToCustomersScreen = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.ADD_CUSTOMER
        ) {
            AddCustomerScreen(
                navigateToCustomersScreen = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.VEHICLES
        ) {
            VehiclesScreen(
                navigateToAddCustomerScreen = {
                    navController.navigate(Routes.ADD_CUSTOMER)
                },
                navigateToCustomerVehiclesScreen = { customerId ->
                    navController.navigate(Routes.CUSTOMER_VEHICLES + "/${customerId}")
                }
            )
        }
        composable(
            route = Routes.CUSTOMER_VEHICLES + "/{customer_id}",
            arguments = listOf(
                navArgument("customer_id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val customerId: Int = backStackEntry.arguments!!.getInt("customer_id")
            CustomerVehiclesScreen(
                navigateToAddCustomerVehicleScreen = {
                    navController.navigate(Routes.ADD_CUSTOMER_VEHICLE + "/${it}")
                },
                navigateToUpdateCustomerVehicleScreen = {
                    navController.navigate(Routes.UPDATE_CUSTOMER_VEHICLE + "/${it}")
                },
                customerId = customerId
            )
        }
        composable(
            route = Routes.UPDATE_CUSTOMER_VEHICLE + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("id")
            UpdateVehicleScreen(
                id = id,
                navigateToVehiclesScreen = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Routes.ADD_CUSTOMER_VEHICLE + "/{customerId}",
            arguments = listOf(
                navArgument("customerId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val customerId: Int = backStackEntry.arguments!!.getInt("customerId")
            AddVehicleScreen(
                navigateToVehiclesScreen = {
                    navController.popBackStack()
                },
                customerId
            )
        }
        composable(
            route = Routes.MATERIALS
        ) {
            MaterialsScreen(
                navigateToAddMaterialScreen = {
                    navController.navigate(Routes.ADD_MATERIAL)
                },
                navigateToUpdateMaterialScreen = { id ->
                    navController.navigate(Routes.UPDATE_MATERIAL + "/${id}")
                }
            )
        }
        composable(
            route = Routes.ADD_MATERIAL
        ) {
            AddMaterialScreen(
                navigateToMaterialsScreen = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Routes.UPDATE_MATERIAL + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
                        )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("id")
            UpdateMaterialScreen(
                id = id,
                navigateToMaterialsScreen = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Routes.USERS
        ) {
            UsersScreen(
                navigateToAddUserScreen = {
                    navController.navigate(Routes.ADD_USER)
                },
                navigateToAuthenticationScreen = { id ->
                    navController.navigate(Routes.AUTHENTICATION + "/${id}") {

                        // Pop up the authentication page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Routes.ADD_USER
        ) {
            AddUserScreen(
                navigateToUsersScreen = {
                    navController.navigate(Routes.USERS)
                },

                // TODO: Should read onNewUser instead
                navigate = { navigate ->

                    //navController.navigate(Routes.ADD_USER_SETTINGS + "/${id}")
                    navController.navigate(navigate.route){

                        // Pop up the add_user page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Routes.ADD_USER_SETTINGS + "/{Id}",
            arguments = listOf(
                navArgument("Id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("Id")
            AddUserSettingsScreen(
                navigateToUsersScreen = {
                    navController.navigate(Routes.USERS) {

                        // Pop up the user_setting page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                },
                userId = id
            )
        }
        composable(
            route = Routes.AUTHENTICATION + "/{Id}",
            arguments = listOf(
                navArgument("Id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("Id")
            AuthenticationScreen(
                id,
                navigateToUsersScreens = {
                    navController.navigate(Routes.USERS) {

                        // Pop up the authentication page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                },
                navigateToUpdateUserSettings = {
                    navController.navigate(Routes.UPDATE_USER_SETTINGS + "/${id}") {

                        // Pop up the authentication page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Routes.UPDATE_USER_SETTINGS + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id: Int = backStackEntry.arguments!!.getInt("id")
            UpdateUserSettingsScreen(
                id = id,
                navigateToUsersScreen = {
                    navController.navigate(Routes.USERS) {

                        // Pop up the authentication page from the backstack prior to navigate to the destination
                        popUpTo(Routes.SETTINGS) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}































