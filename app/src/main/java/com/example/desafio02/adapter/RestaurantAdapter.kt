package com.example.desafio02.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.MenuActivity
import com.example.desafio02.R
import com.example.desafio02.data.Restaurant
import com.example.desafio02.viewholder.RestaurantViewHolder

class RestaurantAdapter(private val restaurantList: MutableList<Restaurant>): RecyclerView.Adapter<RestaurantViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item,parent,false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount() = restaurantList.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val imgRest = holder.imgRestaurant
        imgRest.setImageResource(restaurantList[position].imgRest)

        val restName = holder.tvRestaurant
        restName.text =restaurantList[position].nameRest

        val restAddress = holder.tvAddress
        restAddress.text = restaurantList[position].address

        val restHour = holder.tvHour
        restHour.text = restaurantList[position].hour

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,MenuActivity::class.java)
            intent.putExtra("IMAGEREST",restaurantList[position].imgRest)
            intent.putExtra("NAMEREST", restaurantList[position].nameRest)
            intent.putExtra("ADDRESSREST",restaurantList[position].address)
            intent.putExtra("HOURREST",restaurantList[position].hour)
            it.context.startActivity(intent)
        }

    }

}