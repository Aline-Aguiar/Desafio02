package com.example.desafio02

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.adapter.MenuAdapter
import com.example.desafio02.data.Menu
import com.example.desafio02.data.Restaurant

class MenuActivity : AppCompatActivity() {

    val imgHeadMenu by lazy { findViewById<ImageView>(R.id.img_head) }
    val imgArrowMenu by lazy { findViewById<ImageView>(R.id.img_arrow) }
    val tvTitleMenu by lazy { findViewById<TextView>(R.id.tv_menu_title) }
    val tvRecycleMenu by lazy { findViewById<TextView>(R.id.tv_menu_recycle) }
    val cardMenu by lazy { findViewById<CardView>(R.id.layout_img_head) }
    val recyclerMenu by lazy { findViewById<RecyclerView>(R.id.recycler_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val information = intent.extras

        if (information != null) {
            initCardView(information)
        }else{
            Toast.makeText(this, "Erro ao carregar informações do restaurante", Toast.LENGTH_LONG).show()
        }

        val dishes = getDishes()

        recyclerMenu.layoutManager= LinearLayoutManager(this)

        //recyclerMenu.layoutManager= GridLayoutManager(this,2)

        val adapterMenu = MenuAdapter(dishes)

        recyclerMenu.adapter = adapterMenu
    }

    private fun getDishes(): MutableList<Menu> {
        val menuList = mutableListOf<Menu>()

        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.aoyama,"Salada com Molho Gengibre","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        return menuList
    }

    private fun initCardView(intent: Bundle){
        val imageMenu = intent.getInt("IMAGEREST")
        val nameMenu = intent.getString("NAMEREST")
        val addressMenu = intent.getString("ADDRESSREST")
        val hourMenu = intent.getString("HOURREST")
        val restGot = Restaurant(imageMenu,nameMenu,addressMenu,hourMenu)

        imgHeadMenu.setImageResource(restGot.imgRest)
        tvTitleMenu.text = restGot.nameRest
    }
}