package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.favourite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

class FavouriteAdapter constructor(val adapterClick: (Int) -> Unit) : ListAdapter<StationModel, FavouriteAdapter.FavouriteViewHolder>(StationCallBack()) {

    inner class FavouriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_fav_station_name)
        val imgStart: ImageView = itemView.findViewById(R.id.img_fav_star)
        val tvCapacity: TextView = itemView.findViewById(R.id.tv_fav_capacity)
        val tvNeed: TextView = itemView.findViewById(R.id.tv_fav_need)
    }


    //use it for determine difference

    class StationCallBack : DiffUtil.ItemCallback<StationModel>() {
        override fun areItemsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.favourite_layout, parent, false))
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val stationModel = getItem(position)

        holder.tvName.text = stationModel.name
        holder.tvCapacity.text = stationModel.capacity.toString()
        holder.tvNeed.text = stationModel.need.toString()

        holder.imgStart.setOnClickListener {

            adapterClick(stationModel.id)
        }
    }


}