package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.Status
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.StationFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.hideTheView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.showTheView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationFragment : BaseFragment<StationFragmentBinding>(R.layout.station_fragment) {

    private val viewModel: StationViewModel by viewModels()
    private lateinit var stationAdapter: StationAdapter
    private var getRemoteData = false
    private lateinit var data: List<StationModel>

    override fun init() {

        setUpAdapter()


        getStationInfo()

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
                    stationAdapter.submitList(data)
                    binding.btnTryAgain.hideTheView()
                }

                Status.ERROR -> {
                    binding.btnTryAgain.showTheView()
                    binding.progressbarStation.hideTheView()
                }
            }
        })
    }

    /**
     * show the recyclerview stations name
     * set up adapter
     */
    private fun setUpAdapter() {

        stationAdapter = StationAdapter()
        {

        }

        binding.rcvStations.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = stationAdapter
        }
    }
}