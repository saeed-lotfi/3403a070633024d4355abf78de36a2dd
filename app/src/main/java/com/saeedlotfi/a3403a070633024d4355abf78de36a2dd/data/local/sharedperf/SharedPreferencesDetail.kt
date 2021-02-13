package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.sharedperf

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel

interface SharedPreferencesDetail {


    /**
     * put speed
     */
    suspend fun putSpeed(value: Int)

    /**
     * put capacity
     */
    suspend fun putCapacity(value: Int)

    /**
     * put power
     */
    suspend fun putPower(value: Int)

    /**
     * put name
     */
    suspend fun putName(name: String)

    /**
     * get current position
     */
    suspend fun getCurrentPosition(): CurrentPositionModel

    /**
     * put new position
     */
    suspend fun putPosition(currentPositionModel: CurrentPositionModel)

    /**
     * get the ship information
     */
    suspend fun getShip(): ShipModel

}