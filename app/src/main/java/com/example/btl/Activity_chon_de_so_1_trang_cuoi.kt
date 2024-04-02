package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_chon_de_so_1_trang_cuoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chon_de_so1_trang_cuoi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addEvents()
    }
    private fun addEvents(){
       xulyNopBai()
    }
    private fun xulyNopBai(){
        val btnNopBai=findViewById<Button>(R.id.btnNopBai)
        btnNopBai.setOnClickListener {
            val intent=Intent(this,Activity_ket_qua::class.java)
            startActivity(intent)
        }
    }
}