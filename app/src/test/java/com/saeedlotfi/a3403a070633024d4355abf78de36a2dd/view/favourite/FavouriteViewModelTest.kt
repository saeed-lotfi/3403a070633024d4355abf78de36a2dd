package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.favourite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.MainCoroutineRule
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.getOrAwaitValueTest
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.GetFavouriteStationUseCase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.UpdateFavouriteStationStatusUseCase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FavouriteViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val updateFavouriteStationStatusUseCase: UpdateFavouriteStationStatusUseCase =
        Mockito.mock(UpdateFavouriteStationStatusUseCase::class.java)

    private val getFavouriteStationUseCase: GetFavouriteStationUseCase =
        Mockito.mock(GetFavouriteStationUseCase::class.java)


    private val favouriteViewModel =
        FavouriteViewModel(updateFavouriteStationStatusUseCase, getFavouriteStationUseCase)


    private val list: List<StationModel> = listOf(
        StationModel(
            "station1", 2,
            4, 8, 4, 1, 1, 0
        ),
        StationModel(
            "station2", 2,
            4, 5, 4, 1, 1, 0
        )
    )


    @Test
    fun `get all favourite list`() = runBlockingTest {
        Mockito.`when`(getFavouriteStationUseCase.invoke())
            .thenReturn(
                list
            )

        favouriteViewModel.getFavouriteList()

        val value = favouriteViewModel.favouriteList.getOrAwaitValueTest()

        Assert.assertEquals(list, value)
    }

}