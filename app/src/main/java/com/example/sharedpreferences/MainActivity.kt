package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var button1 : Button
    lateinit var button2 : Button
    var name = " "
    var city = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)

        button1.setOnClickListener {
             name = editText1.text.toString()
             city = editText2.text.toString()
            //intent to start activity
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("City", city)
            startActivity(intent)
        }
        button2.setOnClickListener {
            name = editText1.text.toString()
            city = editText2.text.toString()
            sharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("name", name)
                putString("city", city)
                apply()
            }
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}