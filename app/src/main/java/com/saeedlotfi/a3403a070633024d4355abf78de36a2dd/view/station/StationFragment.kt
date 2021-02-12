package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import androidx.fragment.app.viewModels
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

    override fun init() {
        getStationInfo()

        binding.btnTryAgain.setOnClickListener {
            getStationInfo()
        }

    }

    private fun getStationInfo() {
        viewModel.getAllStation().observe(this, {
            when (it.status) {
                Status.LOADING -> binding.progressbarStation.showTheView()
                Status.SUCCESS -> {
                    saveStation(it.data!!)
                }
                Status.ERROR -> {
                    binding.btnTryAgain.showTheView()
                    binding.progressbarStation.hideTheView()
                }
            }
        })

    }

    private fun saveStation(data: List<StationModel>) {
        viewModel.saveStations(data).observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    //nothing
                }
                Status.SUCCESS -> binding.btnTryAgain.hideTheView()

                Status.ERROR -> {
                    binding.btnTryAgain.showTheView()
                    binding.progressbarStation.hideTheView()
                }
            }
        })
    }
}