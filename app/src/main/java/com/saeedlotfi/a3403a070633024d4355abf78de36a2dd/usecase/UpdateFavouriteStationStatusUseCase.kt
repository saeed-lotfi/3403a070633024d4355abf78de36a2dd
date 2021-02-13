package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase

import android.util.Log
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.FavouriteRepository
import javax.inject.Inject

class UpdateFavouriteStationStatusUseCase @Inject constructor(private val favouriteRepository: FavouriteRepository) {
    suspend operator fun invoke(id: Int, status: Int) {
        Log.d("tag", "id: $id")
        favouriteRepository.updateFavouriteStatus(id, status)
    }
}