package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.ship

import androidx.lifecycle.ViewModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.PutShipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShipViewModel @Inject constructor(private val useCase: PutShipUseCase) : ViewModel() {


    suspend fun putShipInfo(shipModel: ShipModel) {
        useCase.invoke(shipModel)
    }


}