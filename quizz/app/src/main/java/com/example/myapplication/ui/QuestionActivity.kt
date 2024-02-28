package com.example.myapplication.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.model.Question
import com.example.myapplication.utils.Constants

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var imageCountry: ImageView
    private lateinit var buttonCheck: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private lateinit var questionList: MutableList<Question>

    private lateinit var currentQuestion: Question

    private var currentPosition: Int = 1

    private var selectedOptionPosition: Int = 0

    private var answered: Boolean = false

    private var highAnswer: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        progressBar = findViewById(R.id.progressBar)
        textViewQuestion = findViewById(R.id.textViewQuestion)
        textViewProgress = findViewById(R.id.textViewProgress)
        buttonCheck = findViewById(R.id.buttonCheck)
        imageCountry = findViewById(R.id.imageCountry)

        textViewOptionOne = findViewById(R.id.option1)
        textViewOptionTwo = findViewById(R.id.option2)
        textViewOptionThree = findViewById(R.id.option3)
        textViewOptionFour = findViewById(R.id.option4)

        questionList = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        if (buttonCheck.text.toString() == "FINISH") {
            Intent(this, ResultActivity::class.java).also {
                startActivity(it)
            }
        }
        resetOptions()
        currentQuestion = questionList[currentPosition - 1]
        imageCountry.setImageResource(currentQuestion.image)
        progressBar.progress = currentPosition - 1
        textViewQuestion.text = currentQuestion.question
        textViewProgress.text = "$currentPosition/${progressBar.max + 1}"

        textViewOptionOne.text = currentQuestion.optionOne
        textViewOptionTwo.text = currentQuestion.optionTwo
        textViewOptionThree.text = currentQuestion.optionThree
        textViewOptionFour.text = currentQuestion.optionFour

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        buttonCheck.setOnClickListener(this)

        buttonCheck.text = if (questionList.size == currentPosition) "FINISH" else {
            "CHECK"
        }

        currentPosition = currentPosition.inc()
        answered = false
        selectedOptionPosition = 0
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectOptionNumber: Int) {
        resetOptions()

        selectedOptionPosition = selectOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)

        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.select_option_border_bg
        )
    }

    private fun checkAnswer() {
        answered = true
        when (currentQuestion.correctAnswer) {
            1 -> {
                textViewOptionOne.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_option_border_bg
                )
            }

            2 -> {
                textViewOptionTwo.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_option_border_bg
                )
            }

            3 -> {
                textViewOptionThree.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_option_border_bg
                )
            }

            4 -> {
                textViewOptionFour.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_option_border_bg
                )
            }
        }
        if (selectedOptionPosition != currentQuestion.correctAnswer) {
            when (selectedOptionPosition) {
                1 -> {
                    textViewOptionOne.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_option_border_bg
                    )
                }

                2 -> {
                    textViewOptionTwo.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_option_border_bg
                    )
                }

                3 -> {
                    textViewOptionThree.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_option_border_bg
                    )
                }

                4 -> {
                    textViewOptionFour.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_option_border_bg
                    )
                }
            }
        } else {
            highAnswer = highAnswer.inc()
        }

        if(currentPosition < questionList.size) buttonCheck.text = "NEXT"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1 -> {
                if (!answered) selectedOption(textViewOptionOne, 1)
            }

            R.id.option2 -> {
                if (!answered) selectedOption(textViewOptionTwo, 2)
            }

            R.id.option3 -> {
                if (!answered) selectedOption(textViewOptionThree, 3)
            }

            R.id.option4 -> {
                if (!answered) selectedOption(textViewOptionFour, 4)
            }

            R.id.buttonCheck -> {
                if (selectedOptionPosition == 0) {
                    Toast.makeText(this@QuestionActivity, "Please chose answer", Toast.LENGTH_LONG)
                        .show()
                } else if (!answered) checkAnswer()
                else setQuestion()
            }
        }
    }


}