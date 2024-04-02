package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class topic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_topic)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEventstopic()
    }
    private fun addEventstopic(){
        xulybtnde()
        xuliexit()
        xulihome()
    }
    private  fun xuliexit(){
        val btnExit=findViewById<ImageView>(R.id.btnExit)
        btnExit.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
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
    private fun xulybtnde(){
        val btnde=findViewById<Button>(R.id.btnde)
        btnde.setOnClickListener {
            val intent=Intent(this,Activity_chon_de::class.java)
            startActivity(intent)
        }

    }
}