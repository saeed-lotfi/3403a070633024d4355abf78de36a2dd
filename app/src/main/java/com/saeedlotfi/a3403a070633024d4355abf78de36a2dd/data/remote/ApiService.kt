package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.remote

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import retrofit2.http.GET

interface ApiService {

    @GET("e7211664-cbb6-4357-9c9d-f12bf8bab2e2")
    suspend fun getPlanets(): List<StationModel>

}