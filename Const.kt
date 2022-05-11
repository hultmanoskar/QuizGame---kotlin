package com.ogge.quizgame20

object Const {
    fun getQuestions(): ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()

            // Creating the questions

            val q1= Questions(1,
                "How many legs does a spider have?",
                "Five",
                "Seven",
                "Eight",
                "Nine",
                3,
                "It´s more than seven"
            )
            questionsList.add(q1)

            val q2 = Questions(
                2, "What colors are the stars on the American flag?",
                "Blue", "Red",
                "White", "Gold", 3,
                "Hmm...maybe white"
            )

            questionsList.add(q2)


            val q3 = Questions(
                3, "How many planets are in our solar system?",
                "Six", "Seven",
                "Eight", "Nine", 3,
                "It´s not nine!"
            )

            questionsList.add(q3)


            val q4 = Questions(
                4, "Which Disney movie is Elsa in?",
                "Luca", "Frost",
                "Red", "Zootropolis", 2,
                "Something cold..."
            )

            questionsList.add(q4)


            val q5 = Questions(
                5, "What type of fish is Nemo?",
                "Clownfish", "Shark",
                "Angelfish", "Barracuda", 1,
                "He is white and orange!"
            )

            questionsList.add(q5)


            val q6 = Questions(
                6, "How many pairs of wings do bees have?",
                "One", "Two",
                "Three", "Four", 2,
                "Option 1 and 4 is wrong"
            )

            questionsList.add(q6)


            val q7 = Questions(
                7, "Which is the fastest land animal?",
                "Lion", "Tiger",
                "Cheetah", "Antelope", 3,
                "Tiger is not that fast!"
            )

            questionsList.add(q7)


            val q8 = Questions(
                8, "How many arms does an octopus have?",
                "Six", "Seven",
                "Eight", "Nine", 3,
                "Maybe 7+1 ?"
            )

            questionsList.add(q8)


            val q9 = Questions(
                9, "What is the largest planet in the solar system?",
                "Earth", "Jupiter",
                "Mars", "Mercury", 2,
                "Earth and Mars are not the largest"
            )

            questionsList.add(q9)


            val q10 = Questions(
                10, "Where is the Eiffel Tower located?",
                "Paris", "London",
                "Berlin", "Amsterdam", 1,
                "Bon Jour!"
            )
            questionsList.add(q10)

            return questionsList
        }
    }


