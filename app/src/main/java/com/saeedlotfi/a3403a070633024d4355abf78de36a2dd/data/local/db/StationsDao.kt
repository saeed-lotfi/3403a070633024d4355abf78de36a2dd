package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

@Dao
interface StationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: List<StationModel>)

    @Query("select * from StationModel where name like '%' || :search || '%'")
    suspend fun getSearchStations(search: String): List<StationModel>

    @Query("select * from StationModel where favourite == 1")
    suspend fun getFavouriteList(): List<StationModel>

    @Query("update StationModel SET favourite=:status where id=:id")
    suspend fun updateFavouriteList(id: Int, status: Int)

    @Query("select * from StationModel")
    suspend fun getAllStations(): List<StationModel>

}