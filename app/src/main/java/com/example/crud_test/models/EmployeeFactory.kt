package com.example.crud_test.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmployeeFactory (private val repository: EmployeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                EmployeeViewModel::class.java
        )) {
            @Suppress("UNCHECKED-CAST")
            return EmployeeViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Error"
        )
    }
}