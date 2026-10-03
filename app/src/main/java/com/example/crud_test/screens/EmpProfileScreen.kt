package com.example.crud_test.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.crud_test.R
import com.example.crud_test.models.EmployeeViewModel
import com.example.crud_test.models.EmployeeModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmpProfileScreen (
    navController: NavController,
    empModel: EmployeeViewModel
) {
    val employees by empModel.empList.collectAsStateWithLifecycle(
        initialValue = emptyList()
    )

    val context = LocalContext.current;

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "My Application",
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("addemployee")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Floating Button"
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "@2026",
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
            paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .width(300.dp),
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(employees) {
                            employeeslist ->

                        Card (
                            modifier = Modifier.clickable {
                                navController.navigate("updateemployee/${employeeslist.id}")
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .width(250.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = employeeslist.imageres),
                                    contentDescription = "Profile picture",
                                    modifier = Modifier
                                        .size(120.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = employeeslist.name
                                )
                                Text(
                                    text = employeeslist.position
                                )
                                Button(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = {
                                        empModel.deleteEmployee(employeeslist.id)
                                    }
                                ) {
                                    Text(
                                        text = "Remove Employee"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}