package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.ship

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.MainCoroutineRule
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.usecase.PutShipUseCase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ShipViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val putShipUseCase: PutShipUseCase = Mockito.mock(PutShipUseCase::class.java)
    private val shipViewModel: ShipViewModel= ShipViewModel(putShipUseCase)


    @Test
    fun putShip() {

        runBlockingTest {
            shipViewModel.putShipInfo(ShipModel(0, 0, 0, "name"))
        }
    }

}