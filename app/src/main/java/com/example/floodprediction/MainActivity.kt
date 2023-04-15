package com.example.floodprediction

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("HHHHHHH!!")

        var searchButton = findViewById<Button>(R.id.searchButton)
        searchButton.setOnClickListener {
            val intent1 = Intent(this, searchPage::class.java)
            startActivity(intent1)
        }

//        val lat=intent.getStringExtra("lat")
//        val long=intent.getStringExtra("long")
//
//        println("Lat is $lat")
//        println("Long is $long")
//
//        getData(apiKey, "Noida")
    }

    private val apiKey: String = "cb68d8b23b2b4067a9e132355230904"
    private fun getData(apiKey: String, city: String){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.weatherapi.com/v1/current.json?key=${apiKey}&q=${city}&aqi=no\n"

        val jsonRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                printValues(response)
            },
            { Toast.makeText(this,"ERROR! Call failed :(", Toast.LENGTH_LONG).show() })

        queue.add(jsonRequest)
    }

    private fun printValues(response: JSONObject) {
        println("Request get successful!")
        println(response.getJSONObject("location").getString("name"))
    }
}