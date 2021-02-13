package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.StationRepository
import javax.inject.Inject

class GetCurrentPositionUseCase @Inject constructor(private val repository: StationRepository) {

    suspend operator fun invoke() =
            repository.getCurrentPosition()


}