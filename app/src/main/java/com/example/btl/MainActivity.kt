package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.btl.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents()
    }



    private fun addEvents() {
        xulylistview()
        xuliExit()
    }
    private fun xulylistview() {
        var list= mutableListOf<OutData>()
        list.add(OutData(R.drawable.icon_toan,"Toán Học"))
        list.add(OutData(R.drawable.icon_khoa_hoc,"Khoa Học"))
        list.add(OutData(R.drawable.icon_van,"Văn Học"))
        list.add(OutData(R.drawable.icon_nghe_thuat,"Nghệ Thuật"))
        customAdapter= CustomAdapter(this,list)
        val lvmonhoc=findViewById<ListView>(R.id.lvmonhoc)
        lvmonhoc.adapter=customAdapter
        lvmonhoc.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent=Intent(this,topic::class.java)
            when (position) {
                0 -> intent.putExtra("send", "Toán Học")
                1 -> intent.putExtra("send", "Khoa Học")
                2 -> intent.putExtra("send", "Văn Học")
                3 -> intent.putExtra("send", "Nghệ Thuật")
            }
            startActivity(intent)
        }
    }
    private fun xuliExit(){
        val exit=findViewById<ImageView>(R.id.btnexit)
        exit.setOnClickListener {
            finishAffinity()
        }
    }
}