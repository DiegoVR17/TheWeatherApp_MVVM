package com.example.weatherappmvvm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappmvvm.R
import com.example.weatherappmvvm.network.model.Location
import com.example.weatherappmvvm.view.DetailsActivity
import kotlinx.android.synthetic.main.item_location.view.*

class LocationAdapter (private val context: Context) :
        RecyclerView.Adapter<LocationAdapter.ViewHolder>(){
        private var list: List<Location> = ArrayList()

    fun setLocationList(list: List<Location>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LocationAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].title
        holder.latLng.text = list[position].lattLong
        holder.rootView.setOnClickListener{
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra("Location",list[position].woeid)
            intent.putExtra("name",list[position].title)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_location,parent,false)
        )
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val name = v.tv_location_name!!
        val latLng = v.tv_lat_lng!!
        val rootView = v.cv_location!!
    }
}
