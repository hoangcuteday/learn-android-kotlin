package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val listUsers: MutableList<User> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        try {

            // create database
            val myDatabase = this.openOrCreateDatabase("myDatabase", Context.MODE_PRIVATE, null)

            // create table if not exists
            myDatabase.execSQL("create table if not exists USER (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")

            // insert data to table
            //myDatabase.execSQL("INSERT into USER (id, name, age) values (2, 'thien', 11)")
            //myDatabase.execSQL("INSERT into USER (id, name, age) values (3, 'hihi', 11)")

            // select all data from table user
            val data = myDatabase.rawQuery("select * from USER", null)

            if (data != null) {
                data.moveToFirst()
                   do {
                        val id = data.getInt(data.getColumnIndex("id"))
                        val name = data.getString(data.getColumnIndex("name"))
                        val age = data.getInt(data.getColumnIndex("age"))

                        val user = User(id, name, age)

                        listUsers.add(user)
                    }while(data.moveToNext())
                }

            data.close()
        } catch (e: Exception) {
            println(e.message)
        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(listUsers)
        binding.recycler.adapter = adapter
    }
}