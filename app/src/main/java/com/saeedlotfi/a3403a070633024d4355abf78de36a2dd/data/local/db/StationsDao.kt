package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

@Dao
interface StationsDao {

    @Insert
    suspend fun insertAll(products: List<StationModel>)

}