package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val mutableList: MutableList<String> = mutableListOf("hoang", "thien", "hihi", "hehe")

        binding.listView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mutableList
        )

        with(binding.buttonRecycler) {
            setOnClickListener {
                Intent(this@MainActivity, RecyclerView::class.java).also {
                    startActivity(it)
                }
            }
        }

        binding.button.setOnClickListener {
            mutableList.add(binding.edit.text.toString())
            binding.listView.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mutableList
            )
        }
    }
}