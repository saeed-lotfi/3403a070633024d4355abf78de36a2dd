package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

interface StationRepository {

    /**
     * get all stations
     * @return get all station
     */
    suspend fun getAllStations(): List<StationModel>


    /**
     * save all stations
     * @param stationModels the list of of stations
     */
    suspend fun saveAllStations(stationModels: List<StationModel>)


    /**
     * get search stations
     * @return list of station
     */
    suspend fun getSearchStations(searchQuery: String):List<StationModel>


}