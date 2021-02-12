package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.ShipRepositoryImp
import javax.inject.Inject

class PutShipUseCase @Inject constructor(private val repository: ShipRepositoryImp) {

    suspend operator fun invoke(shipModel: ShipModel) {
        repository.putShip(shipModel)
    }

}