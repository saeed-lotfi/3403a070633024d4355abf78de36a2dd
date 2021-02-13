package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.ship

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.ShipModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.ShipFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.showToast
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async

@AndroidEntryPoint
class ShipFragment : BaseFragment<ShipFragmentBinding>(R.layout.ship_fragment) {

    private val viewModel: ShipViewModel by viewModels()

    override fun init() {

        binding.submitShip.setOnClickListener {

            val action = ShipFragmentDirections.actionShipFragmentToStationFragment()
            findNavController().navigate(action)

            val name: String = binding.edtShipName.text.toString()

            // if ship has name
            if (name.isNotEmpty()) {

                val total =
                        binding.capacitySeekbar.progress + binding.powerSeekbar.progress + binding.speedSeekbar.progress


                // if total given point is equal to power
                if (total == resources.getInteger(R.integer.max_point) && checkSeekBarIsNotZero()) {

                    val shipModel = ShipModel(
                            binding.speedSeekbar.progress,
                            binding.capacitySeekbar.progress,
                            binding.powerSeekbar.progress,
                            name
                    )

                    val handler = CoroutineExceptionHandler { _, _ ->
                        requireContext().showToast(getString(R.string.try_again))
                    }

                    val job = lifecycleScope.async(handler) {
                        viewModel.putShipInfo(shipModel)
                    }

                    job.invokeOnCompletion {
                        val action = ShipFragmentDirections.actionShipFragmentToStationFragment()
                        findNavController().navigate(action)
                    }

                } else {
                    requireContext().showToast(getString(R.string.not_loaded))
                }
            } else {
                requireContext().showToast(getString(R.string.enter_name))
            }
        }


    }

    private fun checkSeekBarIsNotZero(): Boolean =
        binding.capacitySeekbar.progress != 0 && binding.powerSeekbar.progress != 0 && binding.speedSeekbar.progress != 0


}