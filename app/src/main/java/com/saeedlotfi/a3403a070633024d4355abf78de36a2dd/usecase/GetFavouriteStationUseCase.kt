package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouriteStationUseCase @Inject constructor(private val repository: FavouriteRepository) {
    suspend operator fun invoke() =
            repository.getFavouriteList()

}