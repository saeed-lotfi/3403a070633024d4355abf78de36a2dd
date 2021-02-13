package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db.StationsDao
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.remote.ApiService
import javax.inject.Inject

class StationRepositoryImp @Inject constructor(private val api: ApiService, private val dao: StationsDao) : StationRepository {
    override suspend fun getAllStations(): List<StationModel> = api.getPlanets()

    override suspend fun saveAllStations(stationModels: List<StationModel>) = dao.insertAll(stationModels)

    override suspend fun getSearchStations(searchQuery: String): List<StationModel> = dao.getSearchStations(searchQuery)

}