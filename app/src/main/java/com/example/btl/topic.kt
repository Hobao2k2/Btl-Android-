package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class topic : AppCompatActivity() {
    private lateinit var txtTopic:TextView
    var topic: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_topic)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        addEventstopic()
    }
    private fun init(){
        txtTopic=findViewById(R.id.txtTopic)
        val i=intent
        val examnull = i.getStringExtra("send")
        val exam: String =examnull?: ""
        topic=exam
        txtTopic.setText("Chào mừng bạn đến với chủ đề "+exam)
    }
    private fun addEventstopic(){
        xulybtn()
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
    private fun xulybtn(){
        val btnDe=findViewById<Button>(R.id.btnDe)
        val btnKho=findViewById<Button>(R.id.btnKho)
        val btnTrungBinh=findViewById<Button>(R.id.btnTrungBinh)
        btnDe.setOnClickListener {
            val intent=Intent(this,Activity_chon_de::class.java)
            intent.putExtra("level","Dễ")
            intent.putExtra("topic",topic)
            startActivity(intent)
        }
        btnKho.setOnClickListener {
            val intent=Intent(this,Activity_chon_de::class.java)
            intent.putExtra("level","Khó")
            intent.putExtra("topic",topic)
            startActivity(intent)
        }
        btnTrungBinh.setOnClickListener {
            val intent=Intent(this,Activity_chon_de::class.java)
            intent.putExtra("level","Trung Bình")
            intent.putExtra("topic",topic)
            startActivity(intent)
        }
    }
}