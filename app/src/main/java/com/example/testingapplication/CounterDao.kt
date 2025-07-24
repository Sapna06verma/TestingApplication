package com.example.testingapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CounterDao {

    @Query("SELECT * FROM counter_table WHERE id = 0")
    fun getCounter(): LiveData<CounterEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCounter(counter: CounterEntity)
}