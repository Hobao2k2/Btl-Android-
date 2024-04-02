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
import com.example.btl.api.Comments
import com.example.btl.api.MyApi
import com.google.gson.Gson
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val BASE_URL="https://jsonplaceholder.typicode.com/"
    private val TAG:String="CHECK_RESPONSE"
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
        getAllComments()
    }
    private fun getAllComments(){
        val api=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.getComments().enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for(comment in it){
                            Log.i(TAG,"onResponse: ${comment.email}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.i(TAG,"onFailure: ${t.message}")
            }

        })
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

            if(position==0){
                val intent=Intent(this,topic::class.java)
                startActivity(intent)
            }
            Toast.makeText(this,"ban chon"+list[position].title,Toast.LENGTH_SHORT).show()
        }
    }
    private fun xuliExit(){
        val exit=findViewById<ImageView>(R.id.btnexit)
        exit.setOnClickListener {
            finishAffinity()
        }
    }
}