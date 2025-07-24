package com.example.testingapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter_table")
data class CounterEntity(
    @PrimaryKey val id: Int = 0, // Always one row
    val value: Int
)
