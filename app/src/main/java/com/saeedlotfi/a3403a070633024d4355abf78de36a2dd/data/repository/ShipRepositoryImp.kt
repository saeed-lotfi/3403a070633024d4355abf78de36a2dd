package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.sharedperf.SharedPreferencesHelper
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import javax.inject.Inject

class ShipRepositoryImp @Inject constructor(private val sharedPreferences: SharedPreferencesHelper) :
    ShipRepository {

    override suspend fun putShip(instance: ShipModel) {
        sharedPreferences.putName(instance.name)
        sharedPreferences.putPower(instance.power)
        sharedPreferences.putCapacity(instance.capacity)
        sharedPreferences.putSpeed(instance.speed)

    }
}