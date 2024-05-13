package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import retrofit2.Callback
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.btl.api.ApiService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Activity_ket_qua : AppCompatActivity() {
    private lateinit var txtDiemSo: TextView
    private lateinit var txtResponse: TextView
    private lateinit var retrofitManager: RetrofitManager
    private lateinit var txtTittle: TextView
    lateinit var level: String
    lateinit var topic: String
    lateinit var stt: String
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
        val i=intent
        val diemsoString = i.getStringExtra("diemso")
        val diemso: String =diemsoString?: ""
        var diemsoInt=diemso.toInt()
        txtDiemSo=findViewById<TextView>(R.id.txtDiemSoGuiQua)
        txtResponse=findViewById<TextView>(R.id.txtResponse)
        txtDiemSo.setText("Bạn dành được "+ diemso+" điểm")
        if(diemsoInt>=0&&diemsoInt<=250){
            txtResponse.setText("Bạn cần cố gắng hơn ở lần sau!")
        }else if(diemsoInt>200&&diemsoInt<=400){
            txtResponse.setText("Bạn dành được mức điểm khá!")
        }else{
            txtResponse.setText("Bạn dành được mức điểm tốt!")
        }
        txtTittle=findViewById(R.id.txtChuDeDangLam)
        level = i.getStringExtra("level") ?: ""
        topic = i.getStringExtra("topic") ?: ""
        stt = i.getStringExtra("stt") ?: ""
        txtTittle.setText("Kết quả bài làm chủ đề "+ topic +" mức độ "+level+" đề số "+stt)
//        addUser()
    }

    private fun addUser() {
        retrofitManager = RetrofitManager()

        // Tạo một đối tượng User mới
        val user = User(
            name = "exampleUser",
            diem = "300"
            // Thêm các trường dữ liệu khác nếu cần
        )

        // Gửi yêu cầu tạo người dùng mới đến máy chủ
        retrofitManager.createUser(user, object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    // Xử lý khi tạo người dùng thành công
                    val userResponse = response.body()
                } else {
                    // Xử lý khi tạo người dùng không thành công
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Xử lý khi gặp lỗi trong quá trình gửi yêu cầu
            }
        })
    }


    class RetrofitManager {
        private val BASE_URL = "http://10.0.2.2:8081"
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun createUser(user: User, callback: Callback<User>) {
            val service = retrofit.create(ApiService::class.java)
            val call = service.createUser(user)
            call.enqueue(callback)
        }
    }

    private fun addEvents(){
        xuliHome()
    }
    private fun xuliHome(){
        val btnHome=findViewById<ImageButton>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}