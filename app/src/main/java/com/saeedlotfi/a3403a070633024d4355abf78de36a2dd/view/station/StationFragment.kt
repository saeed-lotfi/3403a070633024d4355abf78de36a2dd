package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.CurrentPositionModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.Status
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.StationFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.hideTheView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.showTheView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

@AndroidEntryPoint
class StationFragment : BaseFragment<StationFragmentBinding>(R.layout.station_fragment) {

    private val viewModel: StationViewModel by viewModels()
    private lateinit var stationAdapter: StationAdapter
    private var getRemoteData = false
    private lateinit var data: List<StationModel>
    private var ugs: Int = 0
    private var eus: Int = 0
    private var ds: Int = 0

    private var currentPositionModel = CurrentPositionModel(0, 0)

    override fun init() {

        manageHeader()

        getCurrentStation()

        setUpAdapter()

        //todo: get data just once
        getStationInfo()

        manageTryAgainButton()

        manageSearch()

        // get station data from LiveData
        getStationsData()
    }

    //manage header of ship
    private fun manageHeader() {
        viewModel.getHeader().observe(this, {
            it?.let { shipModel ->
                shipModel.apply {
                    eus = speed
                    ugs = capacity
                    ds = power
                    putTheShipModelHeader()
                }
            }

        })


    }

    private fun putTheShipModelHeader() {
        binding.tvUgs.text = ugs.toString()
        binding.tvEus.text = eus.toString()
        binding.tvDs.text = ds.toString()
    }

    private fun getCurrentStation() {
        viewModel.getCurrentStations().observe(this, {
            currentPositionModel = it
        })
    }

    private fun getStationsData() {
        viewModel.stationsList.observe(this, {
            stationAdapter.submitList(it)
        })

        viewModel.getStations()
    }

    // search and result
    private fun manageSearch() {
        binding.edtSearch.doAfterTextChanged {
            binding.edtSearch.text.toString().let { textString ->
                viewModel.getStations(textString)
            }
        }


    }

    // manage try again button
    private fun manageTryAgainButton() {
        binding.btnTryAgain.setOnClickListener {
            if (!getRemoteData)
                getStationInfo()
            else
                saveStationInLocal()
        }
    }

    private fun getStationInfo() {
        viewModel.getAllStation().observe(this, {
            when (it.status) {
                Status.LOADING -> binding.progressbarStation.showTheView()
                Status.SUCCESS -> {
                    data = it.data!!
                    saveStationInLocal()
                }
                Status.ERROR -> {
                    binding.btnTryAgain.showTheView()
                    binding.progressbarStation.hideTheView()
                }
            }
        })

    }

    private fun saveStationInLocal() {
        viewModel.saveStations(data).observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    //nothing
                }
                Status.SUCCESS -> {
                    binding.btnTryAgain.hideTheView()
                }

                Status.ERROR -> {
                    binding.btnTryAgain.showTheView()
                    binding.progressbarStation.hideTheView()
                }
            }
        })
    }

    // show the recyclerview stations name
// set up adapter
    private fun setUpAdapter() {

        stationAdapter = StationAdapter()
        { stationModel, isFavourite, id ->
            if (stationModel == null) {
                viewModel.updateFavouriteStatus(id, isFavourite)
            } else {

                travelToDistance(stationModel)

            }

        }


        binding.rcvStations.apply {
            hasFixedSize()
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = stationAdapter
        }
    }

    private fun travelToDistance(stationModel: StationModel) {
        // get remaining distance by data
        val remainingDistance = ceil(
            sqrt(
                ((currentPositionModel.xPosition - stationModel.coordinateX).toDouble().pow(2)) +
                        ((currentPositionModel.yPosition - stationModel.coordinateY).toDouble()
                            .pow(2))
            )
        )

        // if bigger than our eus ,ugs , ds don't let him to travel
        if (remainingDistance <= eus && ugs >= stationModel.need && ds >= 10 && stationModel.need > 0) {

            //set position to this station
            currentPositionModel =
                CurrentPositionModel(currentPositionModel.xPosition, currentPositionModel.yPosition)

            eus -= remainingDistance.toInt()
            ugs -= stationModel.need
            ds -= 10

            putTheShipModelHeader()

            viewModel.updateInfoAfterTravel(
                stationModel.id,
                currentPositionModel
            )

        }

    }
}