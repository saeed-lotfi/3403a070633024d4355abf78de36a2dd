package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.Resource
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.GetAllStationsUseCase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.PutAllStationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
        private val getAllStationsUseCase: GetAllStationsUseCase,
        private val putAllStationsUseCase: PutAllStationsUseCase
) : ViewModel() {

    fun getAllStation() = liveData(Dispatchers.Main) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(getAllStationsUseCase.invoke()))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.toString()))
        }
    }

    fun saveStations(data: List<StationModel>?) = liveData(Dispatchers.Main) {
        try {
            emit(Resource.success(putAllStationsUseCase.invoke(data!!)))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.toString()))
        }
    }

}