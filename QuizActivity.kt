package com.ogge.quizgame20


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*


class QuizActivity : AppCompatActivity() {


    private var quizList: ArrayList<Questions>? = null
    private var currentQuestion: Int = 1
    private var selectedAltPosition: Int = 0
    private var userName : String? = null
    private var points: Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizList = Const.getQuestions()
        println(quizList!!.size)

        val questionDisplayed = findViewById<TextView>(R.id.display_question)
        val alternative1 = findViewById<TextView>(R.id.alternative1)
        val alternative2 = findViewById<TextView>(R.id.alternative2)
        val alternative3 = findViewById<TextView>(R.id.alternative3)
        val alternative4 = findViewById<TextView>(R.id.alternative4)
        val btnNext = findViewById<Button>(R.id.nextBtn)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val progText = findViewById<TextView>(R.id.prog_text)
        val btnHint = findViewById<Button>(R.id.btnHint)




        userName = intent.getStringExtra(Var.USER_NAME)

        // Setting OnClick to the question alternatives
        // Get different style/background
        alternative1.setOnClickListener{
            selectedAlternativeStyle(alternative1,1)
        }
        alternative2.setOnClickListener{
            selectedAlternativeStyle(alternative2,2)
        }
        alternative3.setOnClickListener{
            selectedAlternativeStyle(alternative3,3)
        }
        alternative4.setOnClickListener{
            selectedAlternativeStyle(alternative4,4)
        }



        // Set Question function -
        // sets questions, alternatives, progressBar, hints
        // So it can be displayed in the right order
        // Updates the progressBar and textView
        fun setQuestion() {
            val question = quizList!![currentQuestion - 1]
            setAltStyle()


            alternative1.text = question.option1
            alternative2.text = question.option2
            alternative3.text = question.option3
            alternative4.text = question.option4
            questionDisplayed.text = question.question
            progressBar.progress = currentQuestion
            progressBar.max= quizList!!.size
            progText.text= "$currentQuestion" +"/"+ "${quizList!!.size}"
            btnHint.setOnClickListener{
                Toast.makeText(this, question.hint, Toast.LENGTH_SHORT).show()
            }
        }
        setQuestion()


        // Moving to next question - onClick
        // Checking if the answer is right or wrong
        btnNext.setOnClickListener {
            if (selectedAltPosition != 0) {
                val question = quizList!![currentQuestion-1]                        // !! = non-null value
                if (selectedAltPosition!=question.correctOption){                  // Checks if the selected alternative is not equal
                                                                                  // to the "right answer"
                    setColor(selectedAltPosition,R.drawable.bg_wrong_answer)     // Sets the color of the wronged pressed alternative to red
                }else {
                    points ++

                }


                setColor(question.correctOption,R.drawable.bg_right_answer)    // Sets the correct Answer color to green

                if  (currentQuestion == quizList!!.size)
                    btnNext.text = "Finish"

                else
                    btnNext.text = "Next"

            }else{
                currentQuestion++
                when{
                    currentQuestion<=quizList!!.size ->{
                        setQuestion()

                    }
                    else ->{
                        val intent = Intent(this, ScoreActivity::class.java)
                        intent.putExtra(Var.USER_NAME, userName)
                        intent.putExtra(Var.Right_answer, points.toString())
                        intent.putExtra(Var.Total_questions, quizList!!.size)
                        startActivity(intent)
                    }

                }

            }
            selectedAltPosition=0





        }
    }

    // Creating a val of type Arraylist
    // That contains TextViews
    // The different alternatives get an index
    private fun setAltStyle(){
        val listAlternative: ArrayList<TextView> = arrayListOf()
        listAlternative.add(0,alternative1)
        listAlternative.add(1,alternative2)
        listAlternative.add(2,alternative3)
        listAlternative.add(3,alternative4)


        // Set textColor and background
        // That we use in selectedAlternativeStyle
        // Default drawable - background
        for (alt in listAlternative) {
            alt.setTextColor(Color.parseColor("#121112"))
            alt.background=ContextCompat.getDrawable(this,R.drawable.bg_alternative)
        }

    }

    // Giving the alternatives an Int
    // So we can use it in btnNext - onClickListener
    private fun setColor(alt: Int, color:Int){
        when(alt){
            1 ->{ alternative1.background=ContextCompat.getDrawable(this, color)
            }
            2 ->{ alternative2.background=ContextCompat.getDrawable(this, color)
            }
            3 ->{ alternative3.background=ContextCompat.getDrawable(this, color)
            }
            4 ->{ alternative4.background=ContextCompat.getDrawable(this, color)
            }
        }

    }
    // function that keeps track on the style when that
    // Alternative is pressed
    // Set - textColor and view background
    private fun selectedAlternativeStyle(view: TextView,alt:Int) {
        setAltStyle()
        selectedAltPosition=alt
        view.setTextColor(Color.parseColor("#121112"))
        view.background=ContextCompat.getDrawable(this,R.drawable.bg_selected_alternative)

    }



}

