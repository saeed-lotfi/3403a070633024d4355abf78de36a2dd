package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.station

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.R
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.model.StationModel

class StationAdapter constructor(val adapterClick: (Boolean, Int, Int) -> Unit) : ListAdapter<StationModel, StationAdapter.StationViewHolder>(StationCallBack()) {

    inner class StationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_station_name)
        val imgStart: ImageView = itemView.findViewById(R.id.img_star)
        val tvCapacity: TextView = itemView.findViewById(R.id.tv_capacity)
        val tvNeed: TextView = itemView.findViewById(R.id.tv_need)
        val travelButton: Button = itemView.findViewById(R.id.btn_travel)

    }


     //use it for determine difference
    class StationCallBack : DiffUtil.ItemCallback<StationModel>() {
        override fun areItemsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: StationModel, newItem: StationModel): Boolean =
                oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        return StationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.station_layout, parent, false))
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {

        val stationModel = getItem(position)

        holder.tvName.text = stationModel.name
        holder.tvCapacity.text = stationModel.capacity.toString()
        holder.tvNeed.text = stationModel.need.toString()

        // adapter click for travel
        holder.travelButton.setOnClickListener { adapterClick(false, 0, stationModel.id) }

        if (stationModel.favourite == 1)
            holder.imgStart.setImageResource(R.drawable.ic_baseline_star_24)
        else
            holder.imgStart.setImageResource(R.drawable.ic_baseline_star_border_24)


        holder.imgStart.setOnClickListener {

            val favourite:Int=stationModel.favourite


            if (favourite == 0)
                holder.imgStart.setImageResource(R.drawable.ic_baseline_star_24)
            else
                holder.imgStart.setImageResource(R.drawable.ic_baseline_star_border_24)

            // if get 1 change it to 0 and vice versa it
            var favouriteStatus = 1
            if (favourite== 1)
                favouriteStatus = 0

            // adapter click for favourite list
            adapterClick(true, favouriteStatus, stationModel.id)

        }

    }

}



