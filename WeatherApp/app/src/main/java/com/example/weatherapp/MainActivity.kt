package com.example.weatherapp

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_city = findViewById<Spinner>(R.id.spn_city)
        var city = ArrayList<Any>()
        city.add("Colombo")
        city.add("Washington")
        city.add("London")
        city.add("Tokyo")
        var adapter = ArrayAdapter<Any> (this, android.R.layout.simple_spinner_item, city)
        spn_city.adapter = adapter

        var selected_city = if(spn_city.selectedItem == "Colombo") "colombo"
        else if(spn_city.selectedItem == "Washington") "washington"
        else if(spn_city.selectedItem == "London") "london"
        else if(spn_city.selectedItem == "Tokyo") "tokyo"
        else "colombo"
        getWeatherData(selected_city)
    }

    @SuppressLint("SetTextI18n")
    fun getWeatherData(city:String) {

        var request = JsonObjectRequest(
            com.android.volley.Request.Method.GET,
            "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=69f503e650105171a22c295f2a7ce03c",
            JSONObject(),
            {   response ->
                val txt_desc = findViewById<TextView>(R.id.txt_desc)
                val txt_temp = findViewById<TextView>(R.id.txt_temp)
                val txt_wind = findViewById<TextView>(R.id.txt_wind)
                val txt_hum = findViewById<TextView>(R.id.txt_hum)

                txt_desc.setText("Description: \t ${response.getJSONArray("weather").getJSONObject(0).get("description").toString()}",)
                txt_temp.setText("Temp: \t ${response.getJSONObject("main").get("temp").toString()}")
                txt_wind.setText("Wind: \t ${response.getJSONObject("wind").get("speed").toString()}")
                txt_hum.setText("Humidity: \t ${response.getJSONObject("main").get("humidity").toString()}")
            },
            {   error ->
                Log.e("error", error.toString())
            }
        )
        Volley.newRequestQueue(applicationContext).add(request)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}