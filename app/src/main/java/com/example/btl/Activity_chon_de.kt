package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_chon_de : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapterSttDe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chon_de)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents()
    }
    private fun addEvents(){
        xulilistview()
        xuliexit()
        xulihome()
    }
    private fun xulilistview(){
        var list= mutableListOf<OutDataSttDe>()
        list.add(OutDataSttDe("Đề số 1",R.drawable.icon_dong_ho,"20 phút",R.drawable.icon_quyen_sach,"20 câu"))
        list.add(OutDataSttDe("Đề số 2",R.drawable.icon_dong_ho,"30 phút",R.drawable.icon_quyen_sach,"30 câu"))
        list.add(OutDataSttDe("Đề số 3",R.drawable.icon_dong_ho,"40 phút",R.drawable.icon_quyen_sach,"40 câu"))
        customAdapter= CustomAdapterSttDe(this,list)
        val lvchonDe=findViewById<ListView>(R.id.lvchonDe)
        lvchonDe.adapter=customAdapter
        lvchonDe.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            if(position==0){
                val de1=Intent(this,Activity_chon_de_so_1::class.java)
                startActivity(de1)
            }
        }
    }private  fun xuliexit(){
        val btnExit=findViewById<ImageView>(R.id.btnExit)
        btnExit.setOnClickListener {
            val intent=Intent(this,topic::class.java)
            startActivity(intent)
        }
    }
    private  fun xulihome(){
        val btnHome=findViewById<ImageView>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}