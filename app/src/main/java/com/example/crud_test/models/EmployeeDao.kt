package com.example.crud_test.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM EmployeeModel")
    fun getAllEmployees() : Flow<List<EmployeeModel>>

    @Insert
    suspend fun insert(emp : EmployeeModel)

    @Update
    suspend fun update(emp : EmployeeModel)

    @Delete
    suspend fun delete(emp : EmployeeModel)
}