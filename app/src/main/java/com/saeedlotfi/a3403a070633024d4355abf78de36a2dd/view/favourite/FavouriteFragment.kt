package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.favourite

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.FavouriteFragmentBinding
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FavouriteFragmentBinding>(R.layout.favourite_fragment) {

    private val viewModel: FavouriteViewModel by viewModels()

    override fun init() {

        val favouriteAdapter = FavouriteAdapter()
        {
            viewModel.deleteFavouriteList(it)
        }

        binding.rcvFavourite.apply {
            adapter = favouriteAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


        viewModel.favouriteList.observe(this, {
            favouriteAdapter.submitList(it)
        })

        viewModel.getFavouriteList()
    }
}