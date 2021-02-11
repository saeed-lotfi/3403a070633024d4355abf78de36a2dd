package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel

interface ShipRepository {

    /**
     * put ship
     */
    suspend fun putShip(instance:ShipModel)

}