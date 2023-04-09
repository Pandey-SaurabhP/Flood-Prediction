package com.example.floodprediction

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var searchButton = findViewById<Button>(R.id.searchButton)
        searchButton.setOnClickListener {
            val intent1 = Intent(this, searchPage::class.java)
            startActivity(intent1)
        }
    }
}