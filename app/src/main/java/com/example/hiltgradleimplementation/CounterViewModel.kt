package com.example.hiltgradleimplementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(private val counterRepository: CounterRepository) : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = _counter

    init {
        loadCounter()
    }

    private fun loadCounter() {
        _counter.value = counterRepository.getCounterValue()
    }
    fun getCounterValue(): Int {
        return counterRepository.getCounterValue()
    }

    fun incrementCounter() {
        counterRepository.incrementCounter()
    }
}