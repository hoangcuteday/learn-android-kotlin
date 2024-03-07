package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(
            listOf (
                Data("chao", "show"),
                Data("tam biet", "show"),
                Data("ngu", "show")
            ),
            object : Onclick {
                override fun setOnClick(text: String) {
                    Toast.makeText(this@RecyclerView, text, Toast.LENGTH_LONG).show()
                }
            }
        )
        binding.recyclerView.adapter = adapter
    }
}