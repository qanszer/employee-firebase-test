package com.example.crud_test.models

import android.app.Application
import androidx.room.Room
import kotlin.getValue

class EmployeeApplication : Application() {
    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "emp_database"
        ).build()
    }

    val empRepository by lazy {
        EmployeeRepository(database.empdao())
    }
}