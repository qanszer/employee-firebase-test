package com.example.crud_test.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.crud_test.models.EmployeeViewModel

@Composable
fun EmpUpdateScreen (
    empId: Int,
    navController: NavController,
    empModel: EmployeeViewModel
) {
    val context = LocalContext.current;

    val employees by empModel.empList.collectAsStateWithLifecycle(
        initialValue = emptyList()
    )

    val empData = employees.find { it.id == empId }

    var empName by remember {
        mutableStateOf(empData?.name ?: "")
    }
    var empPosition by remember {
        mutableStateOf(empData?.position ?: "")
    }

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card{
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Employee Name:"
                )
                TextField(
                    value = empName,
                    onValueChange = { empName = it }
                )

                Text(
                    text = "Employee Position:"
                )
                TextField(
                    value = empPosition,
                    onValueChange = { empPosition = it }
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        empModel.updateEmployee(empId, empName, empPosition);
                        Toast.makeText(context,
                            "Successfully updated ${empName}",
                            Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(
                        text = "Update Employee"
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.popBackStack() }
                ) {
                    Text(
                        text = "Back"
                    )
                }
            }
        }
    }
}