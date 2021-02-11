package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.sharedperf

import android.content.SharedPreferences
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.SHIP_CAPACITY
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.SHIP_NAME
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.SHIP_POWER
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.SHIP_SPEED
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) :
    SharedPreferencesDetail {
    override suspend fun putSpeed(value: Int) {
        sharedPreferences.edit().putInt(SHIP_SPEED, value).apply()
    }

    override suspend fun putCapacity(value: Int) {
        sharedPreferences.edit().putInt(SHIP_CAPACITY, value).apply()
    }

    override suspend fun putPower(value: Int) {
        sharedPreferences.edit().putInt(SHIP_POWER, value).apply()
    }

    override suspend fun putName(name: String) {
        sharedPreferences.edit().putString(SHIP_NAME, name).apply()
    }
}