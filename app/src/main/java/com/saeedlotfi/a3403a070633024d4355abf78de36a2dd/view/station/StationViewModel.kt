package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import android.util.Log
import androidx.lifecycle.*
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.Resource
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.GetAllStationsUseCase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.GetSearchStationsUseCase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.PutAllStationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
        private val getAllStationsUseCase: GetAllStationsUseCase,
        private val putAllStationsUseCase: PutAllStationsUseCase,
        private val getSearchStationsUseCase: GetSearchStationsUseCase
) : ViewModel() {


    private val _stationsList = MutableLiveData<List<StationModel>>()
    val stationsList: LiveData<List<StationModel>> get() = _stationsList


    // job for search
    private var searchJob: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        // Do what you want with the error
        Log.d("tag", error.toString())
    }

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


    fun getStations(searchQuery: String) {
        searchJob?.cancel() // cancel previous job when user enters new letter
        searchJob = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _stationsList.postValue(getSearchStationsUseCase.invoke(searchQuery))
        }
    }
}
