package com.example.desafio02

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio02.data.Menu

class DetailMenuActivity: AppCompatActivity() {

    val imgHeadDetail by lazy { findViewById<ImageView>(R.id.img_head_detail) }
    val tvNameDetail by lazy { findViewById<TextView>(R.id.tv_detail_title) }
    val tvDescriptDetail by lazy { findViewById<TextView>(R.id.tv_detail) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dish)

        val infoDetail = intent.extras

        if (infoDetail != null) {
            initViews(infoDetail)
        }else{
            Toast.makeText(this, "Erro ao carregar informações do prato", Toast.LENGTH_LONG).show()
        }
    }

    private fun initViews(intent : Bundle){
        val imageDetail = intent.getInt("IMAGEMENU")
        val nameDish = intent.getString("NAMEMENU")
        val descriptDish = intent.getString("DESCRIPTMENU")
        val detailGot = Menu(imageDetail,nameDish,descriptDish)

        imgHeadDetail.setImageResource(detailGot.imgMenu)
        tvNameDetail.text = detailGot.nameMenu
        tvDescriptDetail.text = detailGot.description
    }
}