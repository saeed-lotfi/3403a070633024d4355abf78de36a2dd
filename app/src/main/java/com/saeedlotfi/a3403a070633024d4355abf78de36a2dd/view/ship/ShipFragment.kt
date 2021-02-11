package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.ship

import androidx.navigation.fragment.findNavController
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.base.BaseFragment
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.ShipFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShipFragment : BaseFragment<ShipFragmentBinding>(R.layout.ship_fragment) {


    override fun init() {

        binding.submitShip.setOnClickListener {

            if (binding.edtShipName.text!!.isNotEmpty()) {

                val total =
                    binding.capacitySeekbar.progress + binding.powerSeekbar.progress + binding.speedSeekbar.progress

                if (total <= resources.getInteger(R.integer.max_point)) {
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