package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val colors = listOf(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.DKGRAY)

    private lateinit var myButton: FloatingActionButton
    private lateinit var myView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myView = findViewById(R.id.view)
        myButton = findViewById(R.id.myButton_change)

        myButton.setOnClickListener {
            myView.setBackgroundColor(colors[Random.nextInt(colors.size)])
        }
    }
}