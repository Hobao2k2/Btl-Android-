package com.example.btl.api


import com.example.btl.Question
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/question")
    fun getQuestions(): Call<List<Question>>
}