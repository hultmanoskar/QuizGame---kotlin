package com.ogge.quizgame20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        val editName = findViewById<TextView>(R.id.tv_inputName)
        val userPoints = findViewById<TextView>(R.id.tv_points)
        val btnPlayAgain = findViewById<Button>(R.id.play_again_btn)


        // Get the inputName, points and questions
        val userName = intent.getStringExtra(Var.USER_NAME)
        editName.text = userName

        val totQuestions = intent.getIntExtra(Var.Total_questions, 0)
        val points = intent.getStringExtra(Var.Right_answer)
        userPoints.text = "You got $points / $totQuestions"

        btnPlayAgain.setOnClickListener{

        val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)

        }







    }
}