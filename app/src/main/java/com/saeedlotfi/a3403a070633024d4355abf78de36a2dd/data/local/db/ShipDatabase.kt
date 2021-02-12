package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

@Database(entities = [StationModel::class], version = 1)
abstract class ShipDatabase : RoomDatabase() {

    abstract fun stationsDao(): StationsDao

}