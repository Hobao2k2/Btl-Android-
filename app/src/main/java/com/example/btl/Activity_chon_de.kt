package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_chon_de : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapterSttDe
    private lateinit var txtTittle:TextView
    private lateinit var imgAvatar:ImageView
    lateinit var level: String
    lateinit var topic: String
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
        xuliTittle()
        xulilistview()
        xuliexit()
        xulihome()
        xuliImg()
    }

    private fun xuliImg() {
        imgAvatar=findViewById<ImageView>(R.id.imgAvatar)
        val i = intent
        topic = i.getStringExtra("topic") ?: ""
        if(topic=="Toán Học"){
            imgAvatar.setImageResource(R.drawable.img_toan_hoc)
        }else if(topic=="Văn Học"){
            imgAvatar.setImageResource(R.drawable.img_van_hoc)
        }
        else if(topic=="Khoa Học"){
            imgAvatar.setImageResource(R.drawable.img_khoa_hoc)
        }
        else if(topic=="Nghệ Thuật"){
            imgAvatar.setImageResource(R.drawable.img_nghe_thuat)
        }
    }

    private fun xuliTittle() {
        txtTittle=findViewById(R.id.txtTittle)
        val i = intent
        level = i.getStringExtra("level") ?: ""
        topic = i.getStringExtra("topic") ?: ""
        txtTittle.setText("Bạn chọn chủ đề "+ topic +" mức độ "+level)
    }

    private fun xulilistview(){
        var list= mutableListOf<OutDataSttDe>()
        list.add(OutDataSttDe("Đề số 1",R.drawable.icon_dong_ho,"200s",R.drawable.icon_quyen_sach,"10 câu"))
        list.add(OutDataSttDe("Đề số 2",R.drawable.icon_dong_ho,"200s",R.drawable.icon_quyen_sach,"10 câu"))
        list.add(OutDataSttDe("Đề số 3",R.drawable.icon_dong_ho,"200s",R.drawable.icon_quyen_sach,"10 câu"))
        customAdapter= CustomAdapterSttDe(this,list)
        val lvchonDe=findViewById<ListView>(R.id.lvchonDe)
        lvchonDe.adapter=customAdapter
        lvchonDe.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, Activity_chon_de_so_1::class.java)
            when {
                position == 0 && topic== "Văn Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "van-hoc-de-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Văn Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "van-hoc-de-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Văn Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "van-hoc-de-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Văn Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "van-hoc-trung-binh-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Văn Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "van-hoc-trung-binh-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Văn Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "van-hoc-trung-binh-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Văn Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "van-hoc-kho-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Văn Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "van-hoc-kho-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Văn Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "van-hoc-kho-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Khoa Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "khoa-hoc-de-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Khoa Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "khoa-hoc-de-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Khoa Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "khoa-hoc-de-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Khoa Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "khoa-hoc-trung-binh-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Khoa Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "khoa-hoc-trung-binh-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Khoa Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "khoa-hoc-trung-binh-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Khoa Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "khoa-hoc-kho-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Khoa Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "khoa-hoc-kho-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Khoa Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "khoa-hoc-kho-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Nghệ Thuật" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "nghe-thuat-de-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Nghệ Thuật" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "nghe-thuat-de-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Nghệ Thuật" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "nghe-thuat-de-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Nghệ Thuật" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "nghe-thuat-trung-binh-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Nghệ Thuật" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "nghe-thuat-trung-binh-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Nghệ Thuật" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "nghe-thuat-trung-binh-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Nghệ Thuật" && level=="Khó" -> {
                    intent.putExtra("Base_url", "nghe-thuat-kho-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Nghệ Thuật" && level=="Khó" -> {
                    intent.putExtra("Base_url", "nghe-thuat-kho-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Nghệ Thuật" && level=="Khó" -> {
                    intent.putExtra("Base_url", "nghe-thuat-kho-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Toán Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "toan-de-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Toán Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "toan-de-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Toán Học" && level=="Dễ" -> {
                    intent.putExtra("Base_url", "toan-de-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Toán Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "toan-trung-binh-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Toán Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "toan-trung-binh-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Toán Học" && level=="Trung Bình" -> {
                    intent.putExtra("Base_url", "toan-trung-binh-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
                position == 0 && topic== "Toán Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "toan-kho-1")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","1")
                }
                position == 1 && topic== "Toán Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "toan-kho-2")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","2")
                }
                position == 2 && topic== "Toán Học" && level=="Khó" -> {
                    intent.putExtra("Base_url", "toan-kho-3")
                    intent.putExtra("topic",topic)
                    intent.putExtra("level",level)
                    intent.putExtra("stt","3")
                }
            }

            startActivity(intent)
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