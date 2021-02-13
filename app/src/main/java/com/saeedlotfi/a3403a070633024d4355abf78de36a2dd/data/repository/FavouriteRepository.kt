package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

interface FavouriteRepository {

    /**
     * delete station from favourite list
     * @param id of stations
     * @param status if 1 will favourite and 0 will unfavourite lists
     */
    suspend fun updateFavouriteStatus(id: Int, status: Int)

    /**
     * get favourite stations
     */
    suspend fun getFavouriteList():List<StationModel>

}