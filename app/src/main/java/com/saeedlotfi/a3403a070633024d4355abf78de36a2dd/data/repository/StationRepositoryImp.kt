package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db.StationsDao
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.sharedperf.SharedPreferencesHelper
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.remote.ApiService
import javax.inject.Inject

class StationRepositoryImp @Inject constructor(
    private val api: ApiService,
    private val dao: StationsDao,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : StationRepository {

    override suspend fun getAllStationsRemote(): List<StationModel> = api.getPlanets()

    override suspend fun saveAllStations(stationModels: List<StationModel>) =
        dao.insert(stationModels)

    override suspend fun getSearchStations(searchQuery: String): List<StationModel> =
        dao.getSearchStations(searchQuery)

    override suspend fun getAllStations(): List<StationModel> =
        dao.getAllStations()

    override suspend fun getCurrentPosition(): CurrentPositionModel =
        sharedPreferencesHelper.getCurrentPosition()

    override suspend fun updateStation(
        id: Int,
        currentPositionModel: CurrentPositionModel
    ) {
        dao.updateStation(id)
        sharedPreferencesHelper.putPosition(currentPositionModel)
    }

    override suspend fun getShip(): ShipModel =
        sharedPreferencesHelper.getShip()



}