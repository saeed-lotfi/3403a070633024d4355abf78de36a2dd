package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

interface StationRepository {

    /**
     * get all stations from remote
     * @return get all station
     */
    suspend fun getAllStationsRemote(): List<StationModel>


    /**
     * save all stations
     * @param stationModels the list of of stations
     */
    suspend fun saveAllStations(stationModels: List<StationModel>)


    /**
     * get search stations
     * @return list of station
     */
    suspend fun getSearchStations(searchQuery: String): List<StationModel>

    /**
     * get all stations
     * @return get all station
     */
    suspend fun getAllStations(): List<StationModel>

    /**
     *  get current position at the first time
     */
    suspend fun getCurrentPosition(): CurrentPositionModel

    /**
     * update station
     * @param id id of model
     * @param currentPositionModel new positions of ship
     */
    suspend fun updateStation(id: Int, currentPositionModel: CurrentPositionModel)

    /**
     * get ship information
     */
    suspend fun getShip(): ShipModel


}