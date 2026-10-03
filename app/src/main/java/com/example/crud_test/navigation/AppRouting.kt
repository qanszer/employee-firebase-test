package com.example.crud_test.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crud_test.models.EmployeeFactory
import com.example.crud_test.models.EmployeeRepository
import com.example.crud_test.models.EmployeeViewModel
import com.example.crud_test.screens.EmpProfileScreen
import com.example.crud_test.screens.EmpRegistrationScreen
import com.example.crud_test.screens.EmpUpdateScreen
import com.example.crud_test.screens.MenuScreen

@Composable
fun AppNavigation(
    repository: EmployeeRepository
) {
    val navrouting = rememberNavController()
    val employeeViewModel : EmployeeViewModel = viewModel(
        factory = EmployeeFactory(repository)
    )

    NavHost(
        navController = navrouting,
        startDestination = "menu"
    ) {
        composable("menu") {
            MenuScreen(navrouting)
        }

        composable("employeeslist") {
            EmpProfileScreen(navrouting, employeeViewModel)
        }
        composable("addemployee") {
            EmpRegistrationScreen(navrouting, employeeViewModel)
        }
        composable("updateemployee/{userId}") {
            backStackEntry ->
            val empId = backStackEntry.arguments
                ?.getString("userId")
                ?.toIntOrNull() ?: -1

            EmpUpdateScreen(empId, navrouting, employeeViewModel)
        }
    }
}