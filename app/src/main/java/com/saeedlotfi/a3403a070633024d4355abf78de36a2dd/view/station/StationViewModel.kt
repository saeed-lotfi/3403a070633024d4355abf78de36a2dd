package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import android.util.Log
import androidx.lifecycle.*
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.Resource
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val getAllStationsRemoteRemoteUseCase: GetAllStationsRemoteUseCase,
    private val putAllStationsUseCase: PutAllStationsUseCase,
    private val getSearchStationsUseCase: GetSearchStationsUseCase,
    private val updateFavouriteStationStatusUseCase: UpdateFavouriteStationStatusUseCase,
    private val getAllStationUseCase: GetAllStationsUseCase,
    private val getCurrentPositionUseCase: GetCurrentPositionUseCase,
    private val updateStationUseCase: UpdateStationUseCase,
    private val getShipUseCase: GetShipUseCase
) : ViewModel() {


    private val _stationsList = MutableLiveData<List<StationModel>>()
    val stationsList: LiveData<List<StationModel>> get() = _stationsList


    // job for search
    private var searchJob: Job? = null

    // get stations list
    private var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        Log.d("tag", "rrpr   $error")
    }

    fun getAllStation() = liveData(Dispatchers.Main) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(getAllStationsRemoteRemoteUseCase.invoke()))
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


    fun getStations(searchQuery: String) {
        searchJob?.cancel() // cancel previous job when user enters new letter
        searchJob = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _stationsList.postValue(getSearchStationsUseCase.invoke(searchQuery))
        }
    }

    fun updateFavouriteStatus(id: Int, favourite: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            updateFavouriteStationStatusUseCase.invoke(id, favourite)
            getStations()
        }
    }

    fun getStations() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _stationsList.postValue(getAllStationUseCase.invoke())
        }
    }

    fun getCurrentStations() = liveData(Dispatchers.Main) {
        try {
            emit(getCurrentPositionUseCase.invoke())
        } catch (exception: Exception) {
            emit(CurrentPositionModel(0, 0))
        }
    }

    fun updateInfoAfterTravel(
        id: Int,
        currentPositionModel: CurrentPositionModel
    ) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            updateStationUseCase.invoke(id, currentPositionModel)
        }
    }

    fun getHeader() = liveData(Dispatchers.Main) {
        try {
            emit(getShipUseCase.invoke())
        } catch (exception: Exception) {
            emit(null)
        }
    }

}
