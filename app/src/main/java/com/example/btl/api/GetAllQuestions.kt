package com.example.btl.api

import android.util.Log
import com.example.btl.Answer
import com.example.btl.Question
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL="http://10.0.2.2:8081"
private val TAG="Check_response"

class GetAllQuestions {
    interface QuestionCallback {
        fun onSuccess(questions: MutableList<Question>)
        fun onFailure(message: String)
    }

    fun getAllQuestions(callback: QuestionCallback) {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        api.getQuestionsByExam("toan-de-2").enqueue(object : Callback<List<Question>> {
            override fun onResponse(
                call: Call<List<Question>>,
                response: Response<List<Question>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val questionList = mutableListOf<Question>()
                        for(question in it){
                            val listAnswer1 = mutableListOf<Answer>()
                            listAnswer1.add(Answer(question.answers.get(0).content,question.answers.get(0).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(1).content,question.answers.get(1).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(2).content,question.answers.get(2).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(3).content,question.answers.get(3).isCorrect))
                            questionList.add(Question(question.index,question.title,listAnswer1))
//                        }
                        }
                        callback.onSuccess(questionList)
                    }
                } else {
                    callback.onFailure("Failed to retrieve questions")
                }
            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                callback.onFailure("Error: ${t.message}")
            }
        })
    }
}
