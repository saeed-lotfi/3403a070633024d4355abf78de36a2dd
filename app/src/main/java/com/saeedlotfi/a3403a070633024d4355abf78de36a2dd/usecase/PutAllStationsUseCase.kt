package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.StationRepository
import javax.inject.Inject

class PutAllStationsUseCase @Inject constructor(private val stationRepository: StationRepository) {

    suspend operator fun invoke(stationModels: List<StationModel>) {
        stationRepository.saveAllStations(stationModels)
    }

}