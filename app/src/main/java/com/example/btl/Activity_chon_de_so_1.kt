package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.btl.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class Activity_chon_de_so_1 : AppCompatActivity(),View.OnClickListener {
    var currentQuestion=0
    var diemso=0;
    lateinit var mquestion: Question
    private lateinit var txtIndexQuestion: TextView
    private lateinit var txtcontentQuestion: TextView
    private lateinit var txtanswer1: TextView
    private lateinit var txtanswer2: TextView
    private lateinit var txtanswer3: TextView
    private lateinit var txtanswer4: TextView
    private lateinit var txtDiemSo: TextView
    private lateinit var txtTimer: TextView
    private  var questionList: MutableList<Question> = mutableListOf()
    private val BASE_URL="http://10.0.2.2:8081"
    private val TAG="Check_response"
    private val handler = Handler(Looper.getMainLooper())
    private var countDownTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chon_de_so1)
        init()
        getAllQuestions()
        startCountDown()
    }


    private fun getAllQuestions(){
        val api=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        api.getQuestions().enqueue(object : Callback<List<Question>>{
            override fun onResponse(
                call: Call<List<Question>>,
                response: Response<List<Question>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for(question in it){
                            val listAnswer1 = mutableListOf<Answer>()
                            listAnswer1.add(Answer(question.answers.get(0).content,question.answers.get(0).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(1).content,question.answers.get(1).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(2).content,question.answers.get(2).isCorrect))
                            listAnswer1.add(Answer(question.answers.get(3).content,question.answers.get(3).isCorrect))
                            questionList.add(Question(question.index,question.title,listAnswer1))
//                        }
                        }
                        setDataQuestion(questionList[currentQuestion])
                    }
                }
            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                Log.i(TAG,"onFailure: ${t.message}")
            }

        })
    }
    private fun setDataQuestion(question: Question){
        if(question==null){
            return
        }
        mquestion=question
        var titleQuestion: String = "Câu hỏi "+(currentQuestion+1).toString()+"/"+questionList.size.toString()
        txtIndexQuestion.setText(titleQuestion)
        txtcontentQuestion.setText(question.title)
        txtanswer1.setText(question.answers.get(0).content)
        txtanswer2.setText(question.answers.get(1).content)
        txtanswer3.setText(question.answers.get(2).content)
        txtanswer4.setText(question.answers.get(3).content)
        txtanswer1.setOnClickListener(this)
        txtanswer2.setOnClickListener(this)
        txtanswer3.setOnClickListener(this)
        txtanswer4.setOnClickListener(this)
    }
    private fun init(){
        txtIndexQuestion=findViewById<TextView>(R.id.txtindexQuestion)
        txtcontentQuestion=findViewById<TextView>(R.id.txtContentQuestion)
        txtanswer1=findViewById<TextView>(R.id.txtAnswer1)
        txtanswer2=findViewById<TextView>(R.id.txtAnswer2)
        txtanswer3=findViewById<TextView>(R.id.txtAnswer3)
        txtanswer4=findViewById<TextView>(R.id.txtAnswer4)
        txtTimer=findViewById<TextView>(R.id.txtTimer)
        txtDiemSo=findViewById<TextView>(R.id.txtDiemSo)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txtAnswer1->{
                stopCountDown()
                txtanswer1.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer1,mquestion,mquestion.answers.get(0))
                return
            }
            R.id.txtAnswer2->{
                stopCountDown()
                txtanswer2.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer2,mquestion,mquestion.answers.get(1))
                return
            }
            R.id.txtAnswer3->{
                stopCountDown()
                txtanswer3.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer3,mquestion,mquestion.answers.get(2))
                return
            }
            R.id.txtAnswer4->{
                stopCountDown()
                txtanswer4.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer4,mquestion,mquestion.answers.get(3))
                return
            }
        }
    }
    private fun checkAnswer(textView: TextView,question: Question,answer:Answer){
        if(answer.isCorrect=="1"){
            handler.postDelayed({textView.setBackgroundResource(R.drawable.bg_green_corner_30)}, 1000)
            diemso=diemso+50
            handler.postDelayed({ txtDiemSo.setText("Điểm số: "+(diemso).toString())
            }, 1000)
            nextQuestion()
        }
        else if(answer.isCorrect=="0"){
            handler.postDelayed({textView.setBackgroundResource(R.drawable.bg_red_corner_30)}, 1000)
            handler.postDelayed({showAnswerCorrect(question)}, 1000)
            nextQuestion()
        }
    }
    private fun nextQuestion(){
        if(currentQuestion==questionList.size-1){
            val intent=Intent(this,Activity_ket_qua::class.java)
            intent.putExtra("diemso",diemso.toString())
            startActivity(intent)
        }else{
            currentQuestion++;
            handler.postDelayed({
                clearAllSelections()
                setDataQuestion(questionList[currentQuestion])
                startCountDown()
            }, 1500)
        }
    }
    private fun showAnswerCorrect(question: Question){
        if(question.answers.get(0).isCorrect=="1"){
            txtanswer1.setBackgroundResource(R.drawable.bg_green_corner_30)
        }else if(question.answers.get(1).isCorrect=="1"){
            txtanswer2.setBackgroundResource(R.drawable.bg_green_corner_30)
        }else if(question.answers.get(2).isCorrect=="1"){
            txtanswer3.setBackgroundResource(R.drawable.bg_green_corner_30)
        }else {
            txtanswer4.setBackgroundResource(R.drawable.bg_green_corner_30)
        }
    }
    private fun clearAllSelections(){
        txtanswer1.setBackgroundResource(R.drawable.bg_blue_corner_30)
        txtanswer2.setBackgroundResource(R.drawable.bg_blue_corner_30)
        txtanswer3.setBackgroundResource(R.drawable.bg_blue_corner_30)
        txtanswer4.setBackgroundResource(R.drawable.bg_blue_corner_30)
    }
    private var isCountDownRunning = false

    private fun startCountDown() {
        if (isCountDownRunning) {
            countDownTimer?.cancel()
        }

        val timeLeftInMillis: Long = 20000 // 20 giây

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                txtTimer.text = formatTime(seconds)
            }

            override fun onFinish() {
                txtTimer.text = "00:00"
                isCountDownRunning = false
                showAnswerCorrect(mquestion)
                nextQuestion()
            }
        }.start()

        isCountDownRunning = true
    }

    private fun stopCountDown() {
        countDownTimer?.cancel()
        isCountDownRunning = false
    }

    private fun formatTime(seconds: Long): String {
        val minutes = seconds / 60
        val secs = seconds % 60
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)
    }

}