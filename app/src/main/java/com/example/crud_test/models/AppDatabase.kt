package com.example.crud_test.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database ( entities = [EmployeeModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun empdao() : EmployeeDao
}