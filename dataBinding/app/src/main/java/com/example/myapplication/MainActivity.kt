package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            if(binding.editTextText.text.toString().isEmpty()){
                binding.textView.text = "Please type your name"
                binding.textView.setTextColor(Color.RED)
            }else {
                binding.textView.text = binding.editTextText.text.toString();
                binding.textView.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }
}