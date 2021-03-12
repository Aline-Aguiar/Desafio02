package com.example.desafio02.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.R

class MenuViewHolder(view: View):RecyclerView.ViewHolder(view){
    val imgMenu by lazy { view.findViewById<ImageView>(R.id.img_menu_card) }
    val tvMenu by lazy { view.findViewById<TextView>(R.id.tv_menu_dish) }
    val cardMenu by lazy { view.findViewById<CardView>(R.id.card_menu) }
}