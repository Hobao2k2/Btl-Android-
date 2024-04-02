package com.example.btl

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class Activity_chon_de_so_1 : AppCompatActivity(),View.OnClickListener {
    lateinit var mListQuestion: MutableList<Question>
    var currentQuestion=0
    lateinit var mquestion: Question
    private lateinit var txtIndexQuestion: TextView
    private lateinit var txtcontentQuestion: TextView
    private lateinit var txtanswer1: TextView
    private lateinit var txtanswer2: TextView
    private lateinit var txtanswer3: TextView
    private lateinit var txtanswer4: TextView
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chon_de_so1)
        init()
        mListQuestion=getlistquestion()
        if(mListQuestion.isEmpty()){
            return
        }
        setDataQuestion(mListQuestion.get(currentQuestion))
    }
    private fun setDataQuestion(question: Question){
        if(question==null){
            return
        }
        mquestion=question
        var titleQuestion: String = "Câu hỏi "+question.index.toString()
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
    }
    private fun getlistquestion():MutableList<Question>{
        val listQuestion= mutableListOf<Question>()
        val listAnswer1= mutableListOf<Answer>()
        listAnswer1.add(Answer("gà",true))
        listAnswer1.add(Answer("cá",false))
        listAnswer1.add(Answer("bò",false))
        listAnswer1.add(Answer("lợn",false))
        listQuestion.add(Question(1,"Con nào là gia cầm",listAnswer1))
        val listAnswer2= mutableListOf<Answer>()
        listAnswer2.add(Answer("Hà Nội",true))
        listAnswer2.add(Answer("Hà Tĩnh",false))
        listAnswer2.add(Answer("Thái Nguyên",false))
        listAnswer2.add(Answer("Nghệ An",false))
        listQuestion.add(Question(2,"Đâu là thủ đô của Việt Nam",listAnswer2))
        return listQuestion
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txtAnswer1->{
                txtanswer1.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer1,mquestion,mquestion.answers.get(0))
                return
            }
            R.id.txtAnswer2->{
                txtanswer2.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer2,mquestion,mquestion.answers.get(1))
                return
            }
            R.id.txtAnswer3->{
                txtanswer3.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer3,mquestion,mquestion.answers.get(2))
                return
            }
            R.id.txtAnswer4->{
                txtanswer4.setBackgroundResource(R.drawable.bg_orange_corner_30)
                checkAnswer(txtanswer4,mquestion,mquestion.answers.get(3))
                return
            }
        }
    }
    private fun checkAnswer(textView: TextView,question: Question,answer:Answer){
        if(answer.isCorrect){
            handler.postDelayed({textView.setBackgroundResource(R.drawable.ic_launcher_background)}, 1000)
            nextQuestion()
        }
        else if(!answer.isCorrect){
            handler.postDelayed({textView.setBackgroundResource(R.drawable.bg_red_corner_20)}, 1000)
            handler.postDelayed({showAnswerCorrect(question)}, 1000)
            nextQuestion()
        }
    }
    private fun nextQuestion(){
        if(currentQuestion==mListQuestion.size-1){
            Toast.makeText(this,"ban win",Toast.LENGTH_LONG).show()
        }else{
            currentQuestion++;
            handler.postDelayed({clearAllSelections()}, 2500)
            handler.postDelayed({setDataQuestion(mListQuestion.get(currentQuestion))}, 2500)
        }
    }
    private fun showAnswerCorrect(question: Question){
        if(question.answers.get(0).isCorrect){
            txtanswer1.setBackgroundResource(R.drawable.bg_green_corner_30)
        }else if(question.answers.get(1).isCorrect){
            txtanswer2.setBackgroundResource(R.drawable.bg_green_corner_30)
        }else if(question.answers.get(2).isCorrect){
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
}