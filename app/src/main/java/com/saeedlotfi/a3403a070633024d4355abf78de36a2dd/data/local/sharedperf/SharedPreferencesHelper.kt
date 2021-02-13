package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.sharedperf

import android.content.SharedPreferences
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.*
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

    override suspend fun putPosition(currentPositionModel: CurrentPositionModel) {
        sharedPreferences.edit().putInt(CURRENT_X, currentPositionModel.xPosition)
            .putInt(CURRENT_Y, currentPositionModel.yPosition).apply()
    }

    override suspend fun getShip(): ShipModel =
        ShipModel(
            sharedPreferences.getInt(SHIP_SPEED, 0),
            sharedPreferences.getInt(SHIP_CAPACITY, 0),
            sharedPreferences.getInt(SHIP_POWER, 0),
            sharedPreferences.getString(SHIP_NAME, "")!!
        )


    override suspend fun getCurrentPosition(): CurrentPositionModel {
        return CurrentPositionModel(
            sharedPreferences.getInt(CURRENT_X, 0),
            sharedPreferences.getInt(CURRENT_Y, 0)
        )
    }
}