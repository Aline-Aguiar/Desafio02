package com.example.desafio02.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.R

class RestaurantViewHolder(view:View):RecyclerView.ViewHolder(view){

    val imgRestaurant by lazy { view.findViewById<ImageView>(R.id.img_card) }
    val tvRestaurant by lazy { view.findViewById<TextView>(R.id.tv_name) }
    val tvAddress by lazy { view.findViewById<TextView>(R.id.tv_address) }
    val tvHour by lazy { view.findViewById<TextView>(R.id.tv_hour) }

}