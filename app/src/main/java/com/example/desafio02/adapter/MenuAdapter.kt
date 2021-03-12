package com.example.desafio02.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.DetailMenuActivity
import com.example.desafio02.R
import com.example.desafio02.data.Menu
import com.example.desafio02.viewholder.MenuViewHolder

class MenuAdapter(private val menuList:MutableList<Menu>):RecyclerView.Adapter<MenuViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false)
        return MenuViewHolder(view)
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val imgMenu = holder.imgMenu
        imgMenu.setImageResource(menuList[position].imgMenu)

        val menuName = holder.tvMenu
        menuName.text = menuList[position].nameMenu

        holder.itemView.setOnClickListener {
            val intentMenu = Intent(it.context, DetailMenuActivity::class.java)
            intentMenu.putExtra("IMAGEMENU",menuList[position].imgMenu)
            intentMenu.putExtra("NAMEMENU",menuList[position].nameMenu)
            intentMenu.putExtra("DESCRIPTMENU", menuList[position].description)
            it.context.startActivity(intentMenu)
        }
    }
}