package com.example.crud_test.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployeeModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val position: String,
    val imageres: Int,
)