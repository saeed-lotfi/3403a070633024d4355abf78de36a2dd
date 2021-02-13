package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db.StationsDao
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import javax.inject.Inject

class FavouriteRepositoryImp @Inject constructor(private val stationsDao: StationsDao) : FavouriteRepository {
    override suspend fun updateFavouriteStatus(id: Int, status: Int) {
        stationsDao.updateFavouriteList(id,status)
    }

    override suspend fun getFavouriteList(): List<StationModel> =
            stationsDao.getFavouriteList()
}