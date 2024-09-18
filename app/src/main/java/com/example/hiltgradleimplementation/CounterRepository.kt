package com.example.hiltgradleimplementation

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CounterRepository @Inject constructor(private val sharedPreferences: SharedPreferences) {
    companion object {
        private const val COUNTER_KEY = "counter_key"
    }

    fun getCounterValue(): Int {
        return sharedPreferences.getInt(COUNTER_KEY, 0)
    }

    fun incrementCounter() {
        val currentValue = getCounterValue()
        sharedPreferences.edit().putInt(COUNTER_KEY, currentValue + 1).apply()
    }
}