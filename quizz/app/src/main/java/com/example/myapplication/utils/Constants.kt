package com.example.myapplication.utils

import com.example.myapplication.R
import com.example.myapplication.model.Question

object Constants {


    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val quest1 = Question(
            1, "What country does this flag belong?",
            R.drawable.argentina_flag,
            "Italy", "China", "Argentina", "Brazil",
            3
        )
        questions.add(quest1)

        val quest2 = Question(
            2, "What country does this flag belong?",
            R.drawable.brazil_flag,
            "VietNam", "India", "Mexico", "Brazil",
            4
        )
        questions.add(quest2)

        val quest3 = Question(
            3, "What country does this flag belong?",
            R.drawable.england_flag,
            "United State", "Australia", "Japan", "England",
            4
        )
        questions.add(quest3)

        val quest4 = Question(
            4, "What country does this flag belong?",
            R.drawable.france_flag,
                "France", "Nederland", "Indonesia", "Russia",
            1
        )
        questions.add(quest4)

        val quest5 = Question(
            5, "What country does this flag belong?",
            R.drawable.germany_flag,
            "Italy", "Germany", "Spain", "Hungary",
            2
        )
        questions.add(quest5)

        val quest6 = Question(
            6, "What country does this flag belong?",
            R.drawable.nigeria_flag,
            "Iran", "Nigeria", "Ghana", "Denmark",
            2
        )
        questions.add(quest6)

        val quest7 = Question(
            7, "What country does this flag belong?",
            R.drawable.southafrica_flag,
            "South Africa", "Cameroon", "Mexico", "India",
            1
        )
        questions.add(quest7)

        val quest8 = Question(
            8, "What country does this flag belong?",
            R.drawable.southkorea_flag,
            "Poland", "Japan", "Korea", "North Korea",
            3
        )
        questions.add(quest8)

        val quest9 = Question(
            9, "What country does this flag belong?",
            R.drawable.spain_flag,
            "Nederland", "Spain", "Germany", "Portugal",
            2
        )
        questions.add(quest9)

        val quest10 = Question(
            10, "What country does this flag belong?",
            R.drawable.vietnam_flag,
            "China", "ThaiLand", "Belgium", "VietNam",
            4
        )
        questions.add(quest10)

        return questions
    }
}