package com.ogge.quizgame20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val startBtn = findViewById<Button>(R.id.btn_start)
        val editName = findViewById<AppCompatEditText>(R.id.edit_text)




        startBtn.setOnClickListener{
            if (editName.text.toString().isEmpty()) {
                Toast.makeText(this, "Name is not filled!", Toast.LENGTH_SHORT).show()

            }else {

                // Navigate to QuizActivity + send inputName to next Activity

                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Var.USER_NAME,editName.text.toString())
                Toast.makeText(this,"Welcome " + editName.text.toString(),Toast.LENGTH_LONG).show()


                startActivity(intent)
                finish()
            }

        }



    }
}