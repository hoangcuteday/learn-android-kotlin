package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ui.QuestionActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonStart: Button
    private lateinit var editTextName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById(R.id.buttonStart)
        editTextName = findViewById(R.id.editTextName)

        buttonStart.setOnClickListener {
            if (editTextName.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG)
                    .show()
            } else {
                Intent(this@MainActivity, QuestionActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

    }
}