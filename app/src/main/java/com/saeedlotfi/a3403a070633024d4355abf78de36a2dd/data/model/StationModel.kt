package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class StationModel(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("coordinateX") val coordinateX: Int,
        @SerializedName("coordinateY") val coordinateY: Int,
        @SerializedName("capacity") val capacity: Int,
        @SerializedName("stock") val stock: Int,
        @SerializedName("need") val need: Int
)