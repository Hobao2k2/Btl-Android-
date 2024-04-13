package com.example.btl.api


import com.example.btl.Question
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/question/{exam}")
    fun getQuestionsByExam(@Path("exam")exam:String): Call<List<Question>>
}