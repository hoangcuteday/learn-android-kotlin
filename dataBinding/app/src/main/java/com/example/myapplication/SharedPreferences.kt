package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivitySharedPreferencesBinding

class SharedPreferences : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)

        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE)

        val view = binding.root

        setContentView(view)

        sharedPreferences.getString("name", "").let {
            binding.textView2.text = "Welcome";
            if(it != ""){
                binding.textView2.text = "Welcome $it"
                binding.button2.text = "Rename"
                binding.button3.visibility = View.VISIBLE
            }
        }

        with(binding.button2) {
                this.setOnClickListener {
                    sharedPreferences.edit().putString("name", binding.editTextText2.text.toString()).apply()
                    binding.textView2.text = "Welcome + ${binding.editTextText2.text.toString()}"
                    binding.button3.visibility = View.VISIBLE
                    if(this.text == "Put") this.text = "Rename"
                }
        }

        with(binding.button3){
            this.setOnClickListener {
                sharedPreferences.edit().remove("name").apply()
                binding.textView2.text = "Welcome"
                this.visibility = View.INVISIBLE
            }
        }

    }
}