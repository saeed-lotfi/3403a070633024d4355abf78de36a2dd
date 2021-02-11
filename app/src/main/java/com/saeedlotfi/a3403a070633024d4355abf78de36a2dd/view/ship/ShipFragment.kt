package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.ship

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.ShipFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.showToast
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShipFragment : BaseFragment<ShipFragmentBinding>(R.layout.ship_fragment) {

    private val viewModel: ShipViewModel by viewModels()

    override fun init() {

        binding.submitShip.setOnClickListener {

            // if ship has name
            if (binding.edtShipName.text!!.isNotEmpty()) {

                val total =
                    binding.capacitySeekbar.progress + binding.powerSeekbar.progress + binding.speedSeekbar.progress

                // if total given point is not more than total point
                if (total <= resources.getInteger(R.integer.max_point)) {

                    viewModel.

                    val action = ShipFragmentDirections.actionShipFragmentToStationFragment()

                    findNavController().navigate(action)
                } else {
                    requireContext().showToast(getString(R.string.overloaded))
                }
            } else {
                requireContext().showToast(getString(R.string.enter_name))
            }
        }


    }

}