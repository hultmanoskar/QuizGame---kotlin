package com.ogge.quizgame20

data class Questions(

    // Structure of Questions
    val id: Int,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int,
    val hint: String
)
