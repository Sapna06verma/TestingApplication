package com.example.testingapplication

import androidx.lifecycle.LiveData

class CounterRepository(private val dao: CounterDao) {

    val counter: LiveData<CounterEntity?> = dao.getCounter()

    suspend fun saveCounter(value: Int) {
        dao.updateCounter(CounterEntity(value = value))
    }
}
