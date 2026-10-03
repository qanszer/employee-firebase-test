package com.example.crud_test.models

import kotlinx.coroutines.flow.Flow

class EmployeeRepository (private val employeeDao: EmployeeDao) {
    val empList : Flow<List<EmployeeModel>> = employeeDao.getAllEmployees()

    suspend fun empInsert(emp : EmployeeModel) {
        employeeDao.insert(emp)
    }

    suspend fun empUpdate(emp : EmployeeModel) {
        employeeDao.update(emp)
    }

    suspend fun empDelete(emp : EmployeeModel) {
        employeeDao.delete(emp)
    }
}