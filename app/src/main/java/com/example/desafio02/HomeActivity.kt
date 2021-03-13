package com.example.desafio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02.adapter.RestaurantAdapter
import com.example.desafio02.data.Restaurant


class HomeActivity: AppCompatActivity() {

    val recycler by lazy {findViewById<RecyclerView>(R.id.recycler_view)}
    val toolbar by lazy {findViewById<Toolbar>(R.id.toolbar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        val restaurant = getRestaurant()

        recycler.layoutManager= LinearLayoutManager(this)

        val adapter = RestaurantAdapter(restaurant)

        recycler.adapter = adapter
    }

    private fun getRestaurant():MutableList<Restaurant>{
        val restaurantList = mutableListOf<Restaurant>()

        restaurantList.add(Restaurant(R.drawable.tony_romas,"Tony Roma's","Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00"))
        restaurantList.add(Restaurant(R.drawable.aoyama,"Aoyama - Moema","Alameda dos Arapanés, 532 - Moema","Fecha às 00:00"))
        restaurantList.add(Restaurant(R.drawable.outback,"Outback - Moema","Av. Moaci, 187 - Moema, São Paulo","Fecha às 00:00"))
        restaurantList.add(Restaurant(R.drawable.sisenor,"Sí Señor!","Alameda Jauaperi, 626 - Moema","Fecha às 01:00"))
        return restaurantList
    }
}