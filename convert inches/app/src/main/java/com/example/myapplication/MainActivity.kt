package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val gap : Double = 100.0

    private lateinit var myButton: Button
    private lateinit var myEditText: EditText
    private lateinit var myTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.myButton)
        myEditText = findViewById(R.id.myEditText)
        myTextView = findViewById(R.id.myTextView)

        myButton.setOnClickListener {
            myTextView.visibility = View.VISIBLE
            if(myEditText.text.toString().isEmpty()){
                myTextView.text = getString(R.string.text_error)
            } else {
                val res = myEditText.text.toString().toDouble() / gap
                myTextView.text = res.toString() + "m"
            }
        }

    }
}