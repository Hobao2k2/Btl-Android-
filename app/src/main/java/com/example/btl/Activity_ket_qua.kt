package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_ket_qua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ket_qua)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents()
    }
    private fun addEvents(){
        xuliLamLai()
        xuliHome()
    }
    private fun xuliHome(){
        val btnHome=findViewById<ImageButton>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }private fun xuliLamLai(){
        val btnLamlai=findViewById<Button>(R.id.btnLamLai)
        btnLamlai.setOnClickListener {
            val intent=Intent(this,Activity_chon_de_so_1::class.java)
            startActivity(intent)
        }
    }
}