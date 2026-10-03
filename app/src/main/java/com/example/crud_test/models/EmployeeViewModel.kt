package com.example.crud_test.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud_test.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val employeeRepository: EmployeeRepository
) : ViewModel() {
    var empList = employeeRepository.empList

    fun deleteEmployee (userid: Int) {
        viewModelScope.launch {
            val emp = empList.first().find{
                it.id == userid
            }

            emp?.let {
                employeeRepository.empDelete(emp)
            }
        }
    }

    fun addEmployee (
        empName: String,
        empPosition: String
    ) {
        viewModelScope.launch {
            employeeRepository.empInsert(
                EmployeeModel(
                    name = empName,
                    position = empPosition,
                    imageres = R.drawable.pfp
                )
            )
        }
    }

    fun updateEmployee (
        empId: Int,
        empName: String,
        empPosition: String
    ) {
        viewModelScope.launch {
            val emp = empList.first().find{
                it.id == empId
            }

            emp?.let {
                employeeRepository.empUpdate(
                    it.copy(
                        name = empName,
                        position = empPosition,
                        imageres = R.drawable.pfp
                    )
                )
            }
        }
    }
}