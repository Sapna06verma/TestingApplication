package com.example.testingapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).counterDao()
    private val repository = CounterRepository(dao)

    val counter: LiveData<CounterEntity?> = repository.counter

    fun incrementCounter(current: Int) = viewModelScope.launch {
        repository.saveCounter(current + 1)
    }

    fun decrementCounter(current: Int) = viewModelScope.launch {
        repository.saveCounter(current - 1)
    }
}
