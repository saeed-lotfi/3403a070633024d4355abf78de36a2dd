package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.databinding.FavouriteLayoutBinding

class FavouriteAdapter : ListAdapter<StationModel, FavouriteAdapter.FavouriteViewHolder>(StationCallBack()) {

    inner class FavouriteViewHolder(itemView: FavouriteLayoutBinding) : RecyclerView.ViewHolder(itemView.root)

    /**
     * use it for determine difference
     */
    class StationCallBack : DiffUtil.ItemCallback<StationModel>() {
        override fun areItemsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.favourite_layout,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
//        holder.itemView.model = getItem(position)

    }


}