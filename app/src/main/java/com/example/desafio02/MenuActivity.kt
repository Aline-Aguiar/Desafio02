package com.example.desafio02

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
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

        //recyclerMenu.layoutManager= LinearLayoutManager(this)

        recyclerMenu.layoutManager= GridLayoutManager(this,2)

        val adapterMenu = MenuAdapter(dishes)

        recyclerMenu.adapter = adapterMenu

        imgArrowMenu.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getDishes(): MutableList<Menu> {
        val menuList = mutableListOf<Menu>()

        menuList.add(Menu(R.drawable.tony_romas,"Risoto de camarão","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."))
        menuList.add(Menu(R.drawable.sisenor,"Kolache","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."))
        menuList.add(Menu(R.drawable.outback1,"Ribs Fire Bites","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))
        menuList.add(Menu(R.drawable.aoyama1,"Salmão grelhado com molho limão","Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit."))
        menuList.add(Menu(R.drawable.tony_romas,"Paella","Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur."))
        menuList.add(Menu(R.drawable.sisenor,"Chilli","At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi."))
        menuList.add(Menu(R.drawable.outback1,"Ribs Bloomin' Burger","Id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus."))
        menuList.add(Menu(R.drawable.aoyama1,"Salada com Molho Gengibre","Omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae."))
        menuList.add(Menu(R.drawable.tony_romas,"Camarão na moranga","Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."))
        menuList.add(Menu(R.drawable.sisenor,"Burritos","Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."))
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