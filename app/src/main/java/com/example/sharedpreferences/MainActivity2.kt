package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var button3 : Button
    lateinit var textview : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button3 = findViewById(R.id.button3)
        textview = findViewById(R.id.textView)
        //get data from intent
        val intent = intent
        val name = intent.getStringExtra("Name")
        val city = intent.getStringExtra("City")
        textview.text =  "Name: "+name+"\nCity: "+city

        button3.setOnClickListener {
            sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            val name = sharedPreferences.getString("name", "").toString()  // --> retrieves data from Shared Preferences
            val city = sharedPreferences.getString("city", "").toString()  // --> retrieves data from Shared Preferences
            textview.text =  "Name: "+name+"\nCity: "+city
        }

    }
}