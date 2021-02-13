package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class StationModel(
        @SerializedName("name") var name: String,
        @SerializedName("coordinateX") var coordinateX: Int,
        @SerializedName("coordinateY") var coordinateY: Int,
        @SerializedName("capacity") var capacity: Int,
        @SerializedName("stock") var stock: Int,
        @SerializedName("need") var need: Int,
        var favourite: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}