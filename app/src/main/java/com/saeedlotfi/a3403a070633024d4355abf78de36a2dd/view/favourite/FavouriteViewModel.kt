package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.favourite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.GetFavouriteStationUseCase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.UpdateFavouriteStationStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
        private val updateFavouriteStationStatusUseCase: UpdateFavouriteStationStatusUseCase,
        private val getFavouriteStationUseCase: GetFavouriteStationUseCase) : ViewModel() {

    private val _favouriteList = MutableLiveData<List<StationModel>>()
    val favouriteList: LiveData<List<StationModel>> get() = _favouriteList

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        // Do what you want with the error
        Log.d("tag", error.toString())
    }


    fun getFavouriteList() {
        viewModelScope.launch(Dispatchers.Main + exceptionHandler) {
            _favouriteList.postValue(getFavouriteStationUseCase.invoke())
        }
    }

    fun deleteFavouriteList(id: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            updateFavouriteStationStatusUseCase.invoke(id, 0)
        }
    }

}